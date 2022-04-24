package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.entidade.Notificacao;
import com.sptech.dreamhouse.repositorio.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoControle {

    @Autowired
    private NotificacaoRepository repository;

    @GetMapping
    public ResponseEntity<List<Notificacao>> listarNotificacoes() {
        List<Notificacao> detalhes = repository.findAll();
        if (detalhes.isEmpty()) {
            return ResponseEntity.status(204).body(detalhes);
        }
        return ResponseEntity.status(200).body(detalhes);
    }
}

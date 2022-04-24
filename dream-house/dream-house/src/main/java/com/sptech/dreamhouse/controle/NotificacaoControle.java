package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.entidade.Notificacao;
import com.sptech.dreamhouse.repositorio.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoControle {

    @Autowired
    private NotificacaoRepository repository;

    @PostMapping
    private ResponseEntity cadastrarNotificacao(@Valid @RequestBody Notificacao novaNotifcao){
        if(novaNotifcao != null){
            repository.save(novaNotifcao);

            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deletarNotificacao(@PathVariable Integer id){

        repository.deleteById(id);

        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/visualizar/{codigo}")
    private ResponseEntity visualizarNotificacao(@PathVariable Integer codigo){
        repository.marcarVisualizada(true,codigo);

        return ResponseEntity.status(200).build();
    }


}

package com.sptech.dreamhouse.obsever;
import com.sptech.dreamhouse.entidade.Notificacao;
import com.sptech.dreamhouse.repositorio.ObseverRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/observers")
public class ObservaAnuncio implements Obsever{

    @Autowired
    private ObseverRepository repository;

    @Override
    public void enviaNotificacao(Integer fk) {
        Notificacao novaNotificacao = new Notificacao();

        novaNotificacao.setTipoNotificacao("Anuncio");
        novaNotificacao.setConteudo("Anuncio cadastrado com sucesso!");
        novaNotificacao.setFkRecurso(1);

    }
}

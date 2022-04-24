package com.sptech.dreamhouse.obsever;

import com.sptech.dreamhouse.repositorio.NotificacaoRepository;

import java.util.ArrayList;

public interface Obsever {
    void enviaNotificacao(Integer fk);
}

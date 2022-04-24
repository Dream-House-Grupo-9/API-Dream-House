package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface NotificacaoRepository extends JpaRepository<Notificacao,Integer> {

    @Transactional
    @Modifying
    @Query("update Notificacao n set n.visualizada = ?1 where n.codigo = ?2")
    void marcarVisualizada(boolean visualizada, Integer id);
}

package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmailAndSenha(String email, String senha);

    @Transactional
    @Modifying
    @Query("update Cliente c set c.autenticado = ?1 where c.id = ?2")
    void setAutenticacao(boolean autentica, Integer id);

    boolean existsByEmail(String email);

}

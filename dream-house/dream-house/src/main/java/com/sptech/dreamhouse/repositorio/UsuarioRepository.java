package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmailAndSenha(String email, String senha);

    @Transactional
    @Modifying
    @Query("update Usuario u set u.autenticado = ?1 where u.codigo = ?2")
    void setAutenticacao(boolean autentica, Integer codigo);

    boolean existsByEmail(String email);

}

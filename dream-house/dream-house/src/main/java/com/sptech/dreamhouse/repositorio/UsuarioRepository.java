package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u.codigo from Usuario u where u.email = ?1 and u.senha = ?2")
    Integer validaId(String email, String senha);


    @Transactional
    @Modifying
    @Query("update Usuario u set u.autenticado = ?1 where u.codigo = ?2")
    void autenticarUsuario(boolean autentica, Integer codigo);

}

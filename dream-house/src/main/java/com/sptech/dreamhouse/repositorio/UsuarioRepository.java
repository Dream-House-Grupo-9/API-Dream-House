package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario,Integer> {

}

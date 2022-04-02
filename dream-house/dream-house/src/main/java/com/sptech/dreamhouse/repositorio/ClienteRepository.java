package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

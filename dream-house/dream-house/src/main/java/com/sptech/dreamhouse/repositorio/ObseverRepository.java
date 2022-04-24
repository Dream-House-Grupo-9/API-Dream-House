package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObseverRepository extends JpaRepository<DetalhesAnuncio,Integer> {
}

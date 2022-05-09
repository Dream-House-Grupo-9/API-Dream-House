package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.ImagemAnuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagemAnuncioRepository extends JpaRepository<ImagemAnuncio,Integer>{

    List<ImagemAnuncio> findByAnuncioIdAnuncio(Integer id);
}

package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.entidade.ImagemAnuncio;
import com.sptech.dreamhouse.resposta.ConsultaCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
    List<Anuncio> findByCidade(String cidade);
}

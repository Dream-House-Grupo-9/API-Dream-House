package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.resposta.ConsultaCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalhesAnuncioRepository extends JpaRepository<DetalhesAnuncio, Integer> {
//
//    @Query("select new com.sptech.dreamhouse.resposta.ConsultaCard.ConsultaCard(null, a.anuncio.cidade, a.valor_mensal) from DetalhesAnuncio a where a.id_detalhes_anuncio = ?1")
//    ConsultaCard consultaItensCard(Integer id);
}

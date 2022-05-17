package com.sptech.dreamhouse.repositorio;

import com.sptech.dreamhouse.entidade.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

    List<Anuncio> findByCidade(String cidade);

    List<Anuncio> findByDetalheAtivoDiariaTrue();

    List<Anuncio> findByDetalheAtivoSemanalTrue();

    List<Anuncio> findByDetalheAtivoMensalTrue();

    List<Anuncio> findByDetalheValorDiariaBetween(Double valor1,Double valor2);

    List<Anuncio> findByDetalheValorSemanalBetween(Double valor1,Double valor2);

    List<Anuncio> findByDetalheValorMensalBetween(Double valor1,Double valor2);


//    List<Anuncio> getDisponibilidade(LocalDate dataInicio,LocalDate dataFim);


    @Query("select a.foto from Anuncio a where a.id = ?1")
    byte[] getFoto(Integer id);

    @Query("update Anuncio a set a.foto =?2 where a.id = ?1")
    @Transactional
    @Modifying
    int atualizarFoto(Integer id, byte[] novaFoto);
}

package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.entidade.Cliente;
import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import com.sptech.dreamhouse.repositorio.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {AnuncioControle.class})
class AnuncioControleTest {

    @Autowired
    AnuncioControle controller;

    @MockBean
    private AnuncioRepository repository;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    @DisplayName("Sem Anuncio, deveria retornar uma 204 sem corpo")
    void getAnunciosVazio() {

        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Anuncio>> resposta = controller.listaAnuncio();

        assertEquals(new ArrayList<>(), resposta.getBody());

    }

    @Test
    @DisplayName("Sem Anuncio com ID, deveria retornar 204 sem corpo")
    void listaAnuncioPorId() {

        ResponseEntity<List<Anuncio>> resposta = controller.listaAnuncioPorId(1);


        assertEquals(204, resposta.getStatusCodeValue());

    }

    @Test
    void deletarTodos() {
        ResponseEntity<List<Anuncio>> resposta = controller.deletarTodos();

        assertEquals(200, resposta.getStatusCodeValue());

    }

    @Test
    @DisplayName("No filtro por nome, se encontrar, deve retornar 200 COM corpo")
    void filtroCidade() {

        Anuncio casa = mock(Anuncio.class);
        Anuncio apartamento = mock(Anuncio.class);
        List<Anuncio> lista = List.of(casa, apartamento);

        String filtro = "Casa Boa";
        when(repository.findByCidade(filtro)).thenReturn(lista);

        ResponseEntity<List<Anuncio>> resposta = controller.filtroCidade(filtro);
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(lista.size(), resposta.getBody().size());
        assertEquals(casa, resposta.getBody().get(0));

    }
}
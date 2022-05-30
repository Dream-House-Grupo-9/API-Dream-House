package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import com.sptech.dreamhouse.repositorio.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ImagensControleTest {

    @Autowired
    AnuncioControle controller;

    @MockBean
    private AnuncioRepository repository;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    void inserirImagem() {
//      "casdas"

        when(repository.findAll()).thenReturn(new ArrayList<>());
    }
}
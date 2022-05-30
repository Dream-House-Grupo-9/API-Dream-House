package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Cliente;
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
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ClienteControle.class})
class ClienteControleTest {

    @Autowired
    ClienteControle controller;

    @MockBean
    private ClienteRepository repository;

    @Test
    @DisplayName("Sem cliente, deveria retornar uma lista VAZIA")
    void getClientesVazio() {

        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<Cliente>> resposta = controller.listarUsuarios();

        assertEquals(new ArrayList<>(), resposta.getBody());
    }

    @Test
    @DisplayName("Deveria deletar cliente")
    void deletarCliente() {
        ResponseEntity<List<Cliente>> response = controller.deletarCliente(1);

        Integer id = 1;

        when(repository.existsById(id)).thenReturn(false);

        assertEquals(404, response.getStatusCodeValue());
    }


}
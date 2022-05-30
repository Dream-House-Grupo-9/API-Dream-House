package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import com.sptech.dreamhouse.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/dash")
public class DashControle {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/qtd-anuncios")
    public ResponseEntity getAnuncios(){
        long total = anuncioRepository.count();

        return status(200).body(total);
    }

    @GetMapping("/qtd-clientes")
    public ResponseEntity getTtlClientes(){
        long total = clienteRepository.count();

        return status(200).body(total);
    }
}

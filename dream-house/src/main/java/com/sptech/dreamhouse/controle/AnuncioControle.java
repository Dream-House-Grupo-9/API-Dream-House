package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anuncios")
public class AnuncioControle {

    @Autowired
    private AnuncioRepository repository;


}

package com.sptech.dreamhouse.controle;


import antlr.collections.List;
import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.repositorio.ExportacaoTxtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exportacao-anuncios")
public class ExportacaoTxtController {

    @Autowired
    private ExportacaoTxtRepository repository;



}

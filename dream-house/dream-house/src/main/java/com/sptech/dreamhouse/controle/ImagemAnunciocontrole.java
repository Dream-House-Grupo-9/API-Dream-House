package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.ImagemAnuncio;
import com.sptech.dreamhouse.repositorio.ImagemAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagens")
public class ImagemAnunciocontrole {

    @Autowired
    private ImagemAnuncioRepository repository;

    @PostMapping
    public ResponseEntity postImagem(@RequestBody ImagemAnuncio novaImagem){
        if(novaImagem != null){
            repository.save(novaImagem);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<ImagemAnuncio>> getImagen(){
        List<ImagemAnuncio> imagens = repository.findAll();

        if(imagens.isEmpty()){
            return ResponseEntity.status(204).body(imagens);
        }
        return ResponseEntity.status(200).body(imagens);
    }

    @DeleteMapping
    public ResponseEntity deleteCategoria(){
        repository.deleteAll();
        return ResponseEntity.status(200).build();
    }
}

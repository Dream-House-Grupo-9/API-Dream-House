package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.ImagemAnuncio;
import com.sptech.dreamhouse.repositorio.ImagemAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/imagens")
public class ImagemAnuncioControle {

    @Autowired
    private ImagemAnuncioRepository repositoryImg;


    @PostMapping
    public ResponseEntity postImagem(@Valid @RequestBody ImagemAnuncio novaImagem){
        if(novaImagem != null){
            repositoryImg.save(novaImagem);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("/{idAnuncio}")
    public ResponseEntity<List<ImagemAnuncio>> listarImagensAnuncio(@PathVariable Integer idAnuncio){
        List<ImagemAnuncio> imagens = repositoryImg.findByAnuncioIdAnuncio(idAnuncio);

        if(imagens.isEmpty()){
            return ResponseEntity.status(204).body(imagens);
        }
        return ResponseEntity.status(200).body(imagens);
    }

    @DeleteMapping("/{idAnuncio}")
    public ResponseEntity deletarImagem(@PathVariable Integer idImagem){
        repositoryImg.deleteById(idImagem);
        return ResponseEntity.status(200).build();
    }
}

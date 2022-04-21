package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.AvaliacaoAnuncio;
import com.sptech.dreamhouse.repositorio.AvaliacaoAnuncioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoAnuncioControle {

    @Autowired
    private AvaliacaoAnuncioRepositorio repository;

    @PostMapping
    public ResponseEntity postAvaliacao(@RequestBody AvaliacaoAnuncio novaAvaliacao){
        if(novaAvaliacao != null){
            repository.save(novaAvaliacao);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoAnuncio>> getAvaliacao(){
        List<AvaliacaoAnuncio> avaliacoes = repository.findAll();

        if(avaliacoes.isEmpty()){
            return ResponseEntity.status(204).body(avaliacoes);
        }
        return ResponseEntity.status(200).body(avaliacoes);
    }

//    @PutMapping("{id}")
//    public ResponseEntity updateFavorito(@PathVariable Integer id, @RequestBody AvaliacaoAnuncio avaliacaoAtualizado){
//        if(repository.existsById(id)){
//            avaliacaoAtualizado.setIdAvaliacao(id);
//            repository.save(avaliacaoAtualizado);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

    @DeleteMapping
    public ResponseEntity deleteAvaliacao(){
        repository.deleteAll();
        return ResponseEntity.status(200).build();
    }
}

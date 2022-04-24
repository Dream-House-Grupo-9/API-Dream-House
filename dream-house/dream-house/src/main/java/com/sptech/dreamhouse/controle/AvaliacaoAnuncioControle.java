package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.AvaliacaoAnuncio;
import com.sptech.dreamhouse.repositorio.AvaliacaoAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoAnuncioControle {


        @Autowired
        private AvaliacaoAnuncioRepository repository;

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

        @DeleteMapping
        public ResponseEntity deleteAvaliacao(){
            repository.deleteAll();
            return ResponseEntity.status(200).build();
        }

}

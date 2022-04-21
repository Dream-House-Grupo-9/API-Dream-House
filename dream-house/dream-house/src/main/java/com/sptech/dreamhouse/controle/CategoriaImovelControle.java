package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.CategoriaImovel;
import com.sptech.dreamhouse.repositorio.CategoriaImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias-imovel")
public class CategoriaImovelControle {

    @Autowired
    private CategoriaImovelRepository repository;

    @PostMapping
    public ResponseEntity postCategoria(@RequestBody CategoriaImovel novaCategoria){
        if(novaCategoria != null){
            repository.save(novaCategoria);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaImovel>> getCategoria(){
        List<CategoriaImovel> categorias = repository.findAll();

        if(categorias.isEmpty()){
            return ResponseEntity.status(204).body(categorias);
        }
        return ResponseEntity.status(200).body(categorias);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCategoria(@PathVariable Integer id, @RequestBody CategoriaImovel categoriaAtualizada){
        if(repository.existsById(id)){
            categoriaAtualizada.setIdCategoria(id);
            repository.save(categoriaAtualizada);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping
    public ResponseEntity deleteCategoria(){
        repository.deleteAll();
        return ResponseEntity.status(200).build();
    }

}

package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.obsever.ObservaAnuncio;
import com.sptech.dreamhouse.obsever.Subescreve;
import com.sptech.dreamhouse.repositorio.DetalhesAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/detalhes-anuncio")
public class DetalhesAnuncioControle {

   Subescreve subescreve = new Subescreve();

   ObservaAnuncio observador = new ObservaAnuncio();

    @Autowired
    private DetalhesAnuncioRepository repository;

//    @Autowired
//    private AnuncioRepository repositoryAnuncio;


    @PostMapping
    public ResponseEntity cadastrarDetalhesAnuncio(@Valid @RequestBody DetalhesAnuncio detalhe) {

        subescreve.addObservador(observador);

        if (detalhe != null) {

            repository.save(detalhe);

            subescreve.notificarObs();

            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }


    @GetMapping
    public ResponseEntity<List<DetalhesAnuncio>> listarDetalhes() {
        List<DetalhesAnuncio> detalhes = repository.findAll();
        if (detalhes.isEmpty()) {
            return ResponseEntity.status(204).body(detalhes);
        }

        return ResponseEntity.status(200).body(detalhes);
    }


    @DeleteMapping
    public ResponseEntity deletarTodos() {
        repository.deleteAll();

        return ResponseEntity.status(200).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaDetalhesAnuncio(@Valid @PathVariable Integer codigo,
                                                  @RequestBody DetalhesAnuncio detalhesAnuncioAtuaslizado) {
        if (repository.existsById(codigo)) {

            detalhesAnuncioAtuaslizado.setIdDetalhesAnuncio(codigo);
            repository.save(detalhesAnuncioAtuaslizado);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarDetalheAnuncio(@Valid @PathVariable Integer codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}

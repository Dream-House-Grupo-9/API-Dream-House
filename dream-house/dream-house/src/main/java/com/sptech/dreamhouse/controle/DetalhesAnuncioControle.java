package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.obsever.ObservaAnuncio;
import com.sptech.dreamhouse.obsever.Obsever;
import com.sptech.dreamhouse.obsever.Subescreve;
import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import com.sptech.dreamhouse.repositorio.DetalhesAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detalhes-anuncio")
public class DetalhesAnuncioControle extends Subescreve{

    ArrayList<Obsever> observadores = new ArrayList<>();

    ObservaAnuncio obiservador = new ObservaAnuncio();


    public void inscrever(Obsever obs){
        if(!observadores.contains(obs)){

            observadores.add(obs);
        }
    }

    public void subscrever(Obsever obs){
        observadores.remove(obs);
    }

    public void notificarObs(Integer fk){
         for(Obsever obs : observadores){
             obs.enviaNotificacao(fk);
         }
    }


    @Autowired
    private DetalhesAnuncioRepository repository;

//    @Autowired
//    private AnuncioRepository repositoryAnuncio;


    @PostMapping
    public ResponseEntity cadastrarDetalhesAnuncio(@Valid @RequestBody DetalhesAnuncio detalhe) {

        inscrever(obiservador);

        if (detalhe != null) {

            repository.save(detalhe);

            notificarObs(1);

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

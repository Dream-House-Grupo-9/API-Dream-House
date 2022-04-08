package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.entidade.Usuario;
import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/anuncios")
public class AnuncioControle {

    @Autowired
    private AnuncioRepository repository;


    @PostMapping
    private ResponseEntity cadastraAnuncio(@Valid @RequestBody Anuncio novoAnuncio){
         if(novoAnuncio != null){
             repository.save(novoAnuncio);

             return ResponseEntity.status(201).build();
         }

         return ResponseEntity.status(400).build();
    }


    @GetMapping
    private ResponseEntity listaAnuncio(){
        List<Anuncio> anuncios = repository.findAll();

        if(anuncios.isEmpty()){
            return ResponseEntity.status(204).body(anuncios);
        }

        return ResponseEntity.status(200).body(anuncios);
    }


    @DeleteMapping
    public ResponseEntity deletarTodos(){
        repository.deleteAll();

        return ResponseEntity.status(200).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaAnuncio(@PathVariable Integer idAnucio,
                                          @RequestBody Anuncio anuncioAtuaslizado) {
        if (repository.existsById(idAnucio)) {

            anuncioAtuaslizado.setIdAnuncio(idAnucio);
            repository.save(anuncioAtuaslizado);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarAnuncio(@PathVariable Integer codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/filter/{cidade}")
    public ResponseEntity <List<Anuncio>> filtroCidade(@PathVariable String cidade){
        List<Anuncio> anuncios = repository.findAll();
        if(anuncios.isEmpty()){
            return ResponseEntity.status(204).body(repository.findByCidade(cidade));
        }
        return ResponseEntity.status(200).body(repository.findByCidade(cidade));
    }
}

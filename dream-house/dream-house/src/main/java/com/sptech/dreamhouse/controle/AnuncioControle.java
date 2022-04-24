package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Anuncio;
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
    private ResponseEntity <List<Anuncio>> listaAnuncio(){
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

    @GetMapping("/exportar-anuncio")
    public ResponseEntity anuncio() {
        List<Anuncio> lista = repository.findAll();
        String relatorio = "";
        for (Anuncio anuncio : lista) {
            relatorio += ""+anuncio.getIdAnuncio()+", "+anuncio.getDtPublicacao()+", "+anuncio.getDescricao()+", " +
                    ""+anuncio.getInicioDisponibilidade()+", "+anuncio.getFinalDisponibilidade()+", " +
                    ""+anuncio.getCidade()+", "+anuncio.getBairro()+", "+anuncio.getLogradouro()+", " +
                    ""+anuncio.getNumero()+", "+anuncio.getTipoImovel()+"\r\n";
        }
        return ResponseEntity
                .status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"relatorio-de-anuncios.csv\"")
                .body(relatorio);
    }

}

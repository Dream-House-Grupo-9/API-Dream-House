package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.repositorio.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/anuncios")
public class  AnuncioControle {

    @Autowired
    private AnuncioRepository repository;


    @PostMapping
    private ResponseEntity cadastraAnuncio(@Valid @RequestBody Anuncio novoAnuncio){

         if(novoAnuncio != null){
             repository.save(novoAnuncio);

             return status(201).build();
         }

         return status(400).build();
    }

    @GetMapping
    public ResponseEntity <List<Anuncio>> listaAnuncio(){

        List<Anuncio> anuncios = repository.findAll();

        if(anuncios.isEmpty()){
            return status(204).body(anuncios);
        }

        return status(200).body(anuncios);
    }

    @DeleteMapping
    public ResponseEntity deletarTodos(){
        repository.deleteAll();

        return status(200).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaAnuncio(@PathVariable Integer idAnucio,
                                          @RequestBody Anuncio anuncioAtuaslizado) {
        if (repository.existsById(idAnucio)) {

            anuncioAtuaslizado.setId(idAnucio);
            repository.save(anuncioAtuaslizado);

            return status(200).build();
        }

        return status(404).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarAnuncio(@PathVariable Integer codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);

            return status(200).build();
        }
        return status(404).build();
    }


    @GetMapping("/filter/{cidade}")
    public ResponseEntity <List<Anuncio>> filtroCidade(@PathVariable String cidade){
        List<Anuncio> anuncios = repository.findByCidade(cidade);
        if(anuncios.isEmpty()){
            return status(204).body(anuncios);
        }

        return status(200).body(anuncios);
    }

    @PatchMapping(value = "/foto/{codigo}", consumes = "image/jpeg")
    public ResponseEntity patchFoto(@PathVariable Integer codigo,
                                    @RequestBody byte[] novaFoto) {

        int atualizados = repository.atualizarFoto(codigo, novaFoto);
        if (atualizados == 0) {
            return status(404).build();
        }
        return status(200).build();
    }

    @GetMapping(value = "/foto/{codigo}", produces = "image/jpeg")
    public ResponseEntity<byte[]> getFoto(@PathVariable Integer codigo) {

        byte[] foto = repository.getFoto(codigo);
        if (foto == null) {
            return status(404).build();
        }
        return status(200).body(foto);
    }

    @GetMapping("/exportar-anuncio")
    public ResponseEntity anuncio() {
        List<Anuncio> lista = repository.findAll();
        String relatorio = "";
        for (Anuncio anuncio : lista) {
            relatorio += ""+anuncio.getId()+", "+anuncio.getDtPublicacao()+", "+anuncio.getDescricao()+", " +
                    ""+anuncio.getInicioDisponibilidade()+", "+anuncio.getFinalDisponibilidade()+", " +
                    ""+anuncio.getCidade()+", "+anuncio.getBairro()+", "+anuncio.getLogradouro()+", " +
                    ""+anuncio.getNumero()+", "+"Casa"+"\r\n";
        }
        return status(200)
                .header("content-type", "text/csv")
                .header("content-disposition", "filename=\"relatorio-de-anuncios.csv\"")
                .body(relatorio);
    }

}

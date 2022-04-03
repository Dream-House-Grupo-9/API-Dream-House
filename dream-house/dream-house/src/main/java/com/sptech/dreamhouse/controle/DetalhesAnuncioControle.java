package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Anuncio;
import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.repositorio.DetalhesAnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/detalhes-anuncio")

public class DetalhesAnuncioControle {

    @Autowired
    private DetalhesAnuncioRepository repository;


    @PostMapping
    public ResponseEntity cadastrarDetalhesAnuncio(@RequestBody DetalhesAnuncio detalhe) {
        if (detalhe != null) {
            repository.save(detalhe);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }


    @GetMapping
    public ResponseEntity listarDetalhes() {
        List<DetalhesAnuncio> detalhes = repository.findAll();
        if (detalhes.isEmpty()) {
            return ResponseEntity.status(204).body(detalhes);
        }

        return ResponseEntity.status(200).body(detalhes);
    }


    @DeleteMapping
    public ResponseEntity deletarTodos(){
        repository.deleteAll();

        return ResponseEntity.status(200).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaDetalhesAnuncio(@PathVariable Integer codigo,
                                          @RequestBody DetalhesAnuncio detalhesAnuncioAtuaslizado) {
        if (repository.existsById(codigo)) {

            detalhesAnuncioAtuaslizado.setIdDetalhesAnuncio(codigo);
            repository.save(detalhesAnuncioAtuaslizado);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarDetalheAnuncio(@PathVariable Integer codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }


//    @GetMapping("/orcamento/{fkAnuncio}/{qtdOspedagem}")
//    public ResponseEntity consultarOrcamento(
//            @PathVariable int fkAnuncio,
//            @PathVariable int qtdOspedagem) {
//
//        return ResponseEntity.status(200).body(fazerOrcamento(detalhes,fkAnuncio,qtdOspedagem));
//    }

//    public String fazerOrcamento(List<DetalhesAnuncio> lista, Integer fkAnuncio, Integer qtdOspedagem) {
//        Diaria diaria = new Diaria();
//        Semanal semanal = new Semanal();
//        Mensal mensal = new Mensal();
//
//        for(DetalhesAnuncio d : detalhes){
//            if(d.getFkAnuncio().equals(fkAnuncio)){
//                return  "Valor Diaria: " + diaria.calcularPorPeriodo(d,qtdOspedagem) +
//                        "\nValor Semanal: " + semanal.calcularPorPeriodo(d,qtdOspedagem) +
//                        "\nValor Mensal: " + mensal.calcularPorPeriodo(d,qtdOspedagem);
//            }
//        }
//        return "";
//    }
}

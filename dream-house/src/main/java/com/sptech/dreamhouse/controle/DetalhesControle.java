package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.DetalhesAnuncio;
import com.sptech.dreamhouse.strategy.Diaria;
import com.sptech.dreamhouse.strategy.Mensal;
import com.sptech.dreamhouse.strategy.Semanal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detalhes-anuncio")

public class DetalhesControle {

    List<DetalhesAnuncio> detalhes = new ArrayList<>();

    @PostMapping
    public ResponseEntity cadastrarDetalhesAnuncio(@RequestBody DetalhesAnuncio detalhe) {
        if (detalhe != null) {
            detalhes.add(detalhe);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity listarDetalhes() {
        if (detalhes.isEmpty()) {
            return ResponseEntity.status(204).body(detalhes);
        }

        return ResponseEntity.status(200).body(detalhes);
    }

    @GetMapping("/orcamento/{fkAnuncio}/{qtdOspedagem}")
    public ResponseEntity consultarOrcamento(
            @PathVariable int fkAnuncio,
            @PathVariable int qtdOspedagem) {

        return ResponseEntity.status(200).body(fazerOrcamento(detalhes,fkAnuncio,qtdOspedagem));
    }

    public String fazerOrcamento(List<DetalhesAnuncio> lista, Integer fkAnuncio, Integer qtdOspedagem) {
        Diaria diaria = new Diaria();
        Semanal semanal = new Semanal();
        Mensal mensal = new Mensal();

        for(DetalhesAnuncio d : detalhes){
            if(d.getFkAnuncio().equals(fkAnuncio)){
                return  "Valor Diaria: " + diaria.calcularPorPeriodo(d,qtdOspedagem) +
                        "\nValor Semanal: " + semanal.calcularPorPeriodo(d,qtdOspedagem) +
                        "\nValor Mensal: " + mensal.calcularPorPeriodo(d,qtdOspedagem);
            }
        }
        return "";
    }
}

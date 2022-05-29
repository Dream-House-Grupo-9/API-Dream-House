package com.sptech.dreamhouse.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/dash")
public class DashControle {

    @GetMapping("/qtd-anuncios-mes")
    public ResponseEntity<Integer> getAnunciosMes(){
        return status(200).body(0);
    }

    @GetMapping("/qtd-clientes")
    public ResponseEntity<Integer> getTtlClientes(){
        return status(200).body(0);
    }
}

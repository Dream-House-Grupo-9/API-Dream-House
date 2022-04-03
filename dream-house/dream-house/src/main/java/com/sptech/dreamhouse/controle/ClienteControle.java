package com.sptech.dreamhouse.controle;


import com.sptech.dreamhouse.entidade.Cliente;
import com.sptech.dreamhouse.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody Cliente novoCliente){
        if(novoCliente != null){
            repository.save(novoCliente);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

}

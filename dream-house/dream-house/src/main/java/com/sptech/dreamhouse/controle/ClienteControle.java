package com.sptech.dreamhouse.controle;


import com.sptech.dreamhouse.entidade.Cliente;
import com.sptech.dreamhouse.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity postCliente(@RequestBody Cliente novoCliente){
        if(novoCliente != null){
            repository.save(novoCliente);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(){
        List<Cliente> clientes = repository.findAll();

        if(clientes.isEmpty()){
            return ResponseEntity.status(204).body(clientes);
        }
        return ResponseEntity.status(200).body(clientes);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCliente(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        if(repository.existsById(id)){
            clienteAtualizado.setIdCliente(id);
            repository.save(clienteAtualizado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping
    public ResponseEntity deleteClientes(){
        repository.deleteAll();
        return ResponseEntity.status(200).build();
    }


}

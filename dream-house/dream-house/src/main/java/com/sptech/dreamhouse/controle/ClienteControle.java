package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Cliente;
import com.sptech.dreamhouse.repositorio.ClienteRepository;
import com.sptech.dreamhouse.requisicao.AutenticacaoClienteRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin
@RestController
@RequestMapping("/clientes")

public class ClienteControle {

    @Autowired
    private ClienteRepository repository;


    @GetMapping
    public ResponseEntity<List<Cliente>> listarUsuarios() {
        List<Cliente> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            return status(204).body(usuarios);
        }

        return status(200).body(usuarios);
    }


    @PostMapping
    public ResponseEntity cadastrarUsuario(@Valid @RequestBody Cliente novoUsuario) {

        if (novoUsuario != null) {
            if(repository.existsByEmail(novoUsuario.getEmail())){
                return notFound().build();
            } else {
                repository.save(novoUsuario);
                return status(201).build();
            }
        }

        return status(400).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaUsuario(@Valid @PathVariable Integer codigo,
                                          @RequestBody Cliente clienteAtualizado) {
        if (repository.existsById(codigo)) {

            clienteAtualizado.setId(codigo);
            repository.save(clienteAtualizado);

            return status(200).build();
        }

        return status(404).build();
    }


    @DeleteMapping
    public ResponseEntity deletarTodos(){
        repository.deleteAll();

        return status(200).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarCliente(@Valid @PathVariable Integer id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);

            return status(200).build();
        }
        return status(404).build();
    }


    @PostMapping("/login")
    public ResponseEntity fazerLogin(@Valid @RequestBody AutenticacaoClienteRequisicao user) {
        Cliente cliente = repository.findByEmailAndSenha(user.getEmail(), user.getSenha());

        if (cliente == null) {
            return status(400).build();
        } else {
            if(cliente.isAutenticado()){
                return status(404).build();

            }else{
                repository.setAutenticacao(true, cliente.getId());

                return status(200).body(cliente);
            }

        }
    }


    @DeleteMapping("/logout")
    public ResponseEntity fazerLogoff(@Valid @RequestBody AutenticacaoClienteRequisicao user) {
        Cliente cliente = repository.findByEmailAndSenha(user.getEmail(), user.getSenha());

        if (cliente.isAutenticado()) {
            repository.setAutenticacao(false,cliente.getId());
            return status(200).build();

        } else {
            return status(404).build();
        }
    }

}

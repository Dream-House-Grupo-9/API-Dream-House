package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Usuario;
import com.sptech.dreamhouse.repositorio.UsuarioRepository;
import com.sptech.dreamhouse.requisicao.AutenticacaoUsuarioRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioControle {

    @Autowired
    private UsuarioRepository repository;


    @GetMapping
    public ResponseEntity listarUsuarios() {
        List<Usuario> usuarios = repository.findAll();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).body(usuarios);
        }

        return ResponseEntity.status(200).body(usuarios);
    }


    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario novoUsuario) {

        if (novoUsuario != null) {
            repository.save(novoUsuario);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }


//    @PutMapping
//    public ResponseEntity atualizaUsuario(@RequestBody Usuario usuarioAtualizado, ){
//
//    }


    @PostMapping("/autenticacao")
    public ResponseEntity fazerLogin(@RequestBody AutenticacaoUsuarioRequisicao user) {
       Integer idValido = repository.validaId(user.getEmail(), user.getSenha());

        if(repository.getById(idValido).isAutenticado()){
            return ResponseEntity.status(404).body("Usuário já se encontra autenticado");
        }else{
            repository.autenticarUsuario(true,idValido);
            return ResponseEntity.status(200).build();
        }
    }


    @DeleteMapping("/desaltenticacao")
    public ResponseEntity fazerLogoff(@RequestBody AutenticacaoUsuarioRequisicao user){
        Integer idValido = repository.validaId(user.getEmail(), user.getSenha());

        if(repository.getById(idValido).isAutenticado()){
            repository.autenticarUsuario(false,idValido);
            return ResponseEntity.status(200).build();

        }else{
            return ResponseEntity.status(404).build();
        }
    }



}

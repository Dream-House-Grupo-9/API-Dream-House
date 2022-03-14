package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioControle {

    List<Usuario> usuarios = new ArrayList<>();


    @GetMapping
    public ResponseEntity listarUsuarios(){
        if(usuarios.isEmpty()){
            return ResponseEntity.status(204).body(usuarios);
        }

        return ResponseEntity.status(200).body(usuarios);
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario novoUsuario){

        if(novoUsuario != null){
            usuarios.add(novoUsuario);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }

    @DeleteMapping
    public ResponseEntity deletarUsuario(@PathVariable int idUsuario){
        for(Usuario u : usuarios){
            if(u.getIdUsuario() == idUsuario){
                usuarios.remove(idUsuario);

                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }


    @PostMapping("/autenticacao/{usuario}/{senha}")
    public ResponseEntity fazerLogin(@PathVariable String email, @PathVariable String senha) {

        for (Usuario u : usuarios) {
            if (u.autenticarUsuario(email, senha)) {
                u.setAutenticado(true);
                return ResponseEntity.status(200).build();
            }
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/desautenticacao/{email}")
    public ResponseEntity fazerLogoff(@PathVariable String email){

        for(Usuario u : usuarios){
            if(u.getEmail().equals(email)){
                if(u.isAutenticado()){
                    u.setAutenticado(false);
                    return ResponseEntity.status(200).build();
                }else{
                    return ResponseEntity.status(401).build();
                }
            }
        }

        return ResponseEntity.status(404).build();
    }


}

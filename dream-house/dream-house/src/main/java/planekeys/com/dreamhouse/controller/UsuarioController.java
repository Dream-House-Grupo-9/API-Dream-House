package planekeys.com.dreamhouse.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planekeys.com.dreamhouse.entidade.Usuario;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/acessar")
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody Usuario novoUsuario){

        usuarios.add(novoUsuario);

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao/{email}/{senha}")
    public ResponseEntity logar(@PathVariable String email, @PathVariable String senha){

        for(Usuario u : usuarios){
            if(u.getEmail().equals(email) && u.capturaSenha().equals(senha)){
                u.setAutenticado(true);
                return ResponseEntity.status(201).build();
            }
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/autenticacao/{email}")
    public ResponseEntity logoff(@PathVariable String email){

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

    @GetMapping("/autenticados")
    public ResponseEntity getUsuariosAutenticados() {
        return ResponseEntity.status(200).body(usuarios.stream()
                .filter(Usuario::isAutenticado)
                .collect(Collectors.toList()));
    }

}



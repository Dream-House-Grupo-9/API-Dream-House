package com.sptech.dreamhouse.controle;

import com.sptech.dreamhouse.entidade.Usuario;
import com.sptech.dreamhouse.repositorio.UsuarioRepository;
import com.sptech.dreamhouse.requisicao.AutenticacaoUsuarioRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity cadastrarUsuario(@Valid @RequestBody Usuario novoUsuario) {

        if (novoUsuario != null) {
            repository.save(novoUsuario);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity atualizaUsuario(@Valid @PathVariable Integer codigo,
                                          @RequestBody Usuario usuarioAtualizado) {
        if (repository.existsById(codigo)) {

            usuarioAtualizado.setCodigo(codigo);
            repository.save(usuarioAtualizado);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping
    public ResponseEntity deletarTodos(){
        repository.deleteAll();

        return ResponseEntity.status(200).build();
    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity deletarUsuario(@Valid @PathVariable Integer codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }


    @PostMapping("/autenticacao")
    public ResponseEntity fazerLogin(@Valid @RequestBody AutenticacaoUsuarioRequisicao user) {
        Usuario usuario = repository.findByEmailAndSenha(user.getEmail(), user.getSenha());

        if (usuario == null) {
            return ResponseEntity.status(400).build();
        } else {
            if(usuario.isAutenticado()){
                repository.setAutenticacao(true,usuario.getCodigo());
                return ResponseEntity.status(200).build();
            }else{
                return ResponseEntity.status(404).build();
            }

        }
    }


    @DeleteMapping("/desaltenticacao")
    public ResponseEntity fazerLogoff(@Valid @RequestBody AutenticacaoUsuarioRequisicao user) {
        Usuario usuario = repository.findByEmailAndSenha(user.getEmail(), user.getSenha());

        if (usuario.isAutenticado()) {
            repository.setAutenticacao(false,usuario.getCodigo());
            return ResponseEntity.status(200).build();

        } else {
            return ResponseEntity.status(404).build();
        }
    }

}

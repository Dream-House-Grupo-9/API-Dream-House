package school.sptech.c101211003andersonsouzaoliveira.controle;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {


    @PostMapping("/login")
    public ResponseEntity fazerLogin() {


        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/logoff")
    public ResponseEntity fazerLogoff(){


        return ResponseEntity.status(200).build();
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario() {


        return ResponseEntity.status(200).build();
    }

    @DeleteMapping
    public ResponseEntity deletarUsuario(){


        return ResponseEntity.status(200).build();
    }

    @PutMapping
    public ResponseEntity atualizarUsuario(){


        return ResponseEntity.status(200).build();
    }

}

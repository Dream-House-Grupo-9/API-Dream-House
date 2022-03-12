package school.sptech.c101211003andersonsouzaoliveira.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anuncios")
public class AnuncioControle {

    @PostMapping
    public ResponseEntity publicarAnuncio(){

        return ResponseEntity.status(200).build();
    }

    @PutMapping
    public ResponseEntity atualizarAnuncio(){

        return ResponseEntity.status(200).build();
    }

    @DeleteMapping
    public ResponseEntity deletarAnuncio(){

        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity exibirAnuncio(){

        return ResponseEntity.status(200).build();
    }


}

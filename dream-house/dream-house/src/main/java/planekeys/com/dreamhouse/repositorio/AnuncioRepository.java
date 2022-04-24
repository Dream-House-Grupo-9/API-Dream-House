package planekeys.com.dreamhouse.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import planekeys.com.dreamhouse.exportacao.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

}

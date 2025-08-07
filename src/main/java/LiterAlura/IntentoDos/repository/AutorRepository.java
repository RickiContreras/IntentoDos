package LiterAlura.IntentoDos.repository;

import LiterAlura.IntentoDos.model.Autor;
import LiterAlura.IntentoDos.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNacimientoLessThanEqualAndFallecimientoGreaterThanEqual(Integer year1, Integer year2);
    Optional<Autor> findByNombre(String nombre);
}
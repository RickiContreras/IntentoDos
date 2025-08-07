package LiterAlura.IntentoDos.repository;

import LiterAlura.IntentoDos.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloIgnoreCase(String titulo);
    List<Libro> findByIdiomasIgnoreCase(String idioma);
    List<Libro> findByAutorNombre(String nombre);
}
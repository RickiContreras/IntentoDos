package LiterAlura.IntentoDos.service;

import LiterAlura.IntentoDos.model.*;
import LiterAlura.IntentoDos.repository.AutorRepository;
import LiterAlura.IntentoDos.repository.LibroRepository;
import LiterAlura.IntentoDos.api.ConsumoAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private final ConsumoAPI consumoAPI;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public LibroService(ConsumoAPI consumoAPI, LibroRepository libroRepository, AutorRepository autorRepository) {
        this.consumoAPI = consumoAPI;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void buscarYGuardarLibroPorTitulo(String tituloLibro) {
        String json = consumoAPI.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "%20"));

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode resultados = root.get("results");

            if (resultados != null && resultados.isArray() && resultados.size() > 0) {
                DatosLibro datosLibro = mapper.readValue(resultados.get(0).toString(), DatosLibro.class);

                // Verificar si ya existe en la base de datos
                Optional<Libro> libroExistente = libroRepository.findByTituloIgnoreCase(datosLibro.titulo());
                if (libroExistente.isPresent()) {
                    System.out.println("⚠️ El libro ya existe en la base de datos: " + datosLibro.titulo());
                    return;
                }

                DatosAutor datosAutor = datosLibro.autores().length > 0 ? datosLibro.autores()[0] : null;
                if (datosAutor == null) {
                    System.out.println("⚠️ No se encontró autor para el libro.");
                    return;
                }

                // Buscar o guardar autor
                Autor autor = autorRepository.findByNombre(datosAutor.nombre())
                        .orElseGet(() -> {
                            Autor nuevoAutor = new Autor(datosAutor.nombre(), datosAutor.nacimiento(), datosAutor.fallecimiento());
                            return autorRepository.save(nuevoAutor);
                        });

                // Convertir lista de idiomas a cadena
                String idiomas = String.valueOf(datosLibro.idiomas());
                if (idiomas.startsWith("[") && idiomas.endsWith("]")) {
                    idiomas = idiomas.substring(1, idiomas.length() - 1).replace("\"", "");
                }

                Libro libro = new Libro(datosLibro.titulo(), idiomas, datosLibro.descargas(), autor);
                libroRepository.save(libro);

                System.out.println("✅ Libro guardado exitosamente: " + libro);

            } else {
                System.out.println("❌ No se encontraron resultados para ese título.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error al procesar los datos del libro: " + e.getMessage());
        }
    }

    public void listarLibros() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("📚 No hay libros guardados.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("🧑‍🏫 No hay autores guardados.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    public void listarAutoresVivosEnUnAnio(Integer anio) {
        List<Autor> autores = autorRepository.findByNacimientoLessThanEqualAndFallecimientoGreaterThanEqual(anio, anio);
        if (autores.isEmpty()) {
            System.out.println("🕵️ No se encontraron autores vivos en el año " + anio + ".");
        } else {
            System.out.println("📅 Autores vivos en el año " + anio + ":");
            autores.forEach(System.out::println);
        }
    }

    public void listarLibrosPorIdioma(String idioma) {
        List<Libro> libros = libroRepository.findByIdiomasIgnoreCase(idioma);
        if (libros.isEmpty()) {
            System.out.println("🌐 No se encontraron libros en el idioma: " + idioma);
        } else {
            System.out.println("📚 Libros en idioma '" + idioma + "':");
            libros.forEach(System.out::println);
        }
    }
}
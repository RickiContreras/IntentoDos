package LiterAlura.IntentoDos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idiomas;
//    private int descargas;
    private Integer descargas;

    @ManyToOne
    private Autor autor;

    public Libro() {}

//    public Libro(String titulo, String idioma, int descargas, Autor autor) {
    public Libro(String titulo, String idioma, Integer descargas, Autor autor) {
        this.titulo = titulo;
        this.idiomas = idioma;
        this.descargas = descargas;
        this.autor = autor;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getIdioma() { return idiomas; }
//    public int getDescargas() { return descargas; }
    public Integer getDescargas() { return descargas; }
    public Autor getAutor() { return autor; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setIdioma(String idioma) { this.idiomas = idioma; }
//    public void setDescargas(int descargas) { this.descargas = descargas; }
    public void setDescargas(Integer descargas) { this.descargas = descargas; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Libro: '" + titulo + "', Idioma: '" + idiomas + "', Descargas: " + descargas + ", Autor: [" + autor + "]";
    }
}

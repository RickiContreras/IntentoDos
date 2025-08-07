package LiterAlura.IntentoDos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
//    private String nacimiento;
    private Integer nacimiento;
//    private String fallecimiento;
    private Integer fallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Autor() {}

//    public Autor(String nombre, String nacimiento, String fallecimiento) {
    public Autor(String nombre, Integer nacimiento, Integer fallecimiento) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.fallecimiento = fallecimiento;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
//    public String getNacimiento() { return nacimiento; }
    public Integer getNacimiento() { return nacimiento; }
//    public String getFallecimiento() { return fallecimiento; }
    public Integer getFallecimiento() { return fallecimiento; }
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
//    public void setNacimiento(String nacimiento) { this.nacimiento = nacimiento; }
    public void setNacimiento(Integer nacimiento) { this.nacimiento = nacimiento; }
//    public void setFallecimiento(String fallecimiento) { this.fallecimiento = fallecimiento; }
    public void setFallecimiento(Integer fallecimiento) { this.fallecimiento = fallecimiento; }

    @Override
    public String toString() {
        return "Autor: " + nombre + ", Nacimiento: " + nacimiento + ", Fallecimiento: " + fallecimiento;
    }
}
package LiterAlura.IntentoDos.principal;

import LiterAlura.IntentoDos.service.LibroService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private final LibroService libroService;

    public Principal(LibroService libroService) {
        this.libroService = libroService;
    }

    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n==== Menú LiterAlura ====");
            System.out.println("1 - Buscar y guardar libro por título");
            System.out.println("2 - Listar todos los libros");
            System.out.println("3 - Listar todos los autores");
            System.out.println("4 - Listar autores vivos en un año específico");
            System.out.println("5 - Listar libros por idioma");
            System.out.println("0 - Salir");
            System.out.print("Elige una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea

                switch (opcion) {
                    case 1:
                        buscarYGuardarLibro();
                        break;
                    case 2:
                        libroService.listarLibros();
                        break;
                    case 3:
                        libroService.listarAutores();
                        break;
                    case 4:
                        listarAutoresVivosEnAnio();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida, por favor intenta de nuevo.");
                }
            } else {
                System.out.println("Por favor ingresa un número válido.");
                scanner.nextLine(); // Consumir entrada inválida
            }
        }
    }

    private void buscarYGuardarLibro() {
        System.out.print("Escribe el título del libro a buscar y guardar: ");
        String titulo = scanner.nextLine().trim();
        if (!titulo.isEmpty()) {
            libroService.buscarYGuardarLibroPorTitulo(titulo);
        } else {
            System.out.println("El título no puede estar vacío.");
        }
    }

    private void listarAutoresVivosEnAnio() {
        System.out.print("Escribe el año para buscar autores vivos: ");
        if (scanner.hasNextInt()) {
            int anio = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            libroService.listarAutoresVivosEnUnAnio(anio);
        } else {
            System.out.println("Por favor ingresa un año válido.");
            scanner.nextLine(); // Consumir entrada inválida
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Escribe el idioma para listar libros: ");
        String idioma = scanner.nextLine().trim();
        if (!idioma.isEmpty()) {
            libroService.listarLibrosPorIdioma(idioma);
        } else {
            System.out.println("El idioma no puede estar vacío.");
        }
    }
}
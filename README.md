# 📚 LiterAlura

**LiterAlura** es una aplicación Java de consola desarrollada como parte del desafío de Alura Latam. Permite buscar libros a través de la API pública de Gutendex, guardar información en una base de datos PostgreSQL y realizar diversas consultas. El proyecto utiliza Spring Boot, JPA y PostgreSQL, y está orientado a practicar integración de APIs, persistencia de datos y arquitectura en capas.

---

## 🚀 Funcionalidades principales

- 🔍 **Buscar libros por título** en la API de Gutendex.
- 📥 **Guardar libros y autores** en una base de datos local.
- 📚 **Listar todos los libros guardados**.
- 🖊️ **Listar autores registrados**.
- 📅 **Filtrar autores vivos en un año determinado**.
- 🌍 **Filtrar libros por idioma**.
- 🚫 Evita duplicar libros o autores ya existentes en la base de datos.

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Data JPA
  - Spring Web
- **PostgreSQL**
- **Jackson** (para deserialización de JSON)
- **Gutendex API** ([https://gutendex.com/](https://gutendex.com/))

---

## 📦 Estructura del proyecto

```plaintext
└── LiterAlura
    ├── dto
    │   ├── DatosAutor.java
    │   └── DatosLibro.java
    ├── model
    │   ├── Autor.java
    │   └── Libro.java
    ├── repository
    │   ├── AutorRepository.java
    │   └── LibroRepository.java
    ├── service
    │   └── LibroService.java
    ├── api
    │   └── ConsumoAPI.java
    ├── principal
    │   └── Principal.java
    └── IntentoDosApplication.java
```

---

## ⚙️ Requisitos previos

- Java 17 instalado
- PostgreSQL instalado y configurado
- Base de datos llamada `LibroDos` creada en tu sistema
- IDE como IntelliJ IDEA o Eclipse

---

## 🧪 ¿Cómo ejecutar la aplicación?

1. **Cloná el repositorio** o descargalo:
   ```bash
   git clone https://github.com/tu-usuario/literalura.git
   cd literalura
   ```

2. **Configurá la conexión a la base de datos** en `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/LibroDos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Ejecutá la aplicación** desde tu IDE o con:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Interactuá con el menú por consola**.

---

## 📌 Notas adicionales

- Los datos se obtienen desde la API de Gutendex en tiempo real.
- El sistema evita guardar libros y autores duplicados.
- Las entidades se persisten en PostgreSQL mediante JPA.
- La aplicación puede expandirse fácilmente para tener una interfaz web en el futuro.

---

## 👨‍💻 Autor

Desarrollado por [Ricki Contreras](https://www.linkedin.com/in/ricki-contreras/) como parte del desafío **#AluraLatam** - Programa Oracle Next Education.

---

## 📄 Licencia

Este proyecto está bajo licencia MIT. Podés usarlo, modificarlo y compartirlo libremente.
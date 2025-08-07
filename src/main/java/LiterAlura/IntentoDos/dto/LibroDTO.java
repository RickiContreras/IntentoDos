package LiterAlura.IntentoDos.dto;

public record LibroDTO(
        String title,
        String languages,
//        int download_count,
        Integer download_count,
        AutorDTO[] authors
) {}
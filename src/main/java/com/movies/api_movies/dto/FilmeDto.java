package com.movies.api_movies.dto;

import com.movies.api_movies.model.Filme;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FilmeDto(@NotBlank(message = "Titulo Obrigatório.") String titulo, String diretor, LocalDate anoLancamento,
                       @Enumerated(EnumType.STRING)
     Filme.Status status) {

    public FilmeDto(Filme filme) {
        this(
                filme.getTitulo(),
                filme.getDiretor(),
                filme.getAnoLancamento(),
                filme.getStatus()

                );
    }


}


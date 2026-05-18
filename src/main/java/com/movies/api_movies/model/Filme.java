package com.movies.api_movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;


    private String diretor;

    private LocalDate anoLancamento;
    @Enumerated(EnumType.STRING)
    private Status status;


    public enum Status{
        DISPONIVEL, INDISPONIVEL

    }






}

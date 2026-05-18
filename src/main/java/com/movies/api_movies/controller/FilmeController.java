package com.movies.api_movies.controller;

import com.movies.api_movies.dto.FilmeDto;
import com.movies.api_movies.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;
    @GetMapping("/listar")
    public List<FilmeDto> listar() {
        return filmeService.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<FilmeDto>  salvar (@Valid @RequestBody FilmeDto dto) {
        FilmeDto salvo = filmeService.salvar(dto);
        return ResponseEntity.ok(salvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FilmeDto> atualizar(@PathVariable Long id, @RequestBody FilmeDto dto) {
        FilmeDto atualizado = filmeService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}

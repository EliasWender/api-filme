package com.movies.api_movies.service;

import com.movies.api_movies.dto.FilmeDto;
import com.movies.api_movies.model.Filme;
import com.movies.api_movies.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<FilmeDto> listar() {

        return filmeRepository.findAll()
                .stream()
                .map(FilmeDto::new)
                .toList();
    }
    /*ese código acima quer dizer que a cada filme, eu quero um dto a partir dele.
    Pegue todos os filmes do meu banco de dados
    Para cada filme faça um DTO a partir dele
    Por fim faça uma lista pra mim de todos os DTOS.

     Uma outra forma de fazer seria assim:
    List<Filme> filmes = filmeRepository.findAll(); Busca todos os filmes no banco.
    List<FilmeDto> filmesDto = new ArrayList<>();

    for(Filme f : filmes) {
     FilmeDto dto = new FilmeDto(filme);

    filmesDto.add(dto);
    return filmesDto;

     */


    public FilmeDto salvar(FilmeDto dto) {
        Filme filme = new Filme();
        filme.setAnoLancamento(dto.anoLancamento());
        filme.setDiretor(dto.diretor());
        filme.setTitulo(dto.titulo());
        filme.setStatus(dto.status());

        Filme salvo = filmeRepository.save(filme);
        return new FilmeDto(salvo);


    }
    public FilmeDto atualizar(Long id, FilmeDto dto) {
      Filme atualizado = filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado."));
      if(dto.anoLancamento().getYear()<= 1900) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ano deve ser maior que 1900.");
      }

      atualizado.setStatus(dto.status());
      atualizado.setTitulo(dto.titulo());
      atualizado.setDiretor(dto.diretor());
      atualizado.setAnoLancamento(dto.anoLancamento());
      Filme salvo = filmeRepository.save(atualizado);
      return new FilmeDto(salvo);



    }
    public void deletar(long id) {
        Filme deletado = filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado."));
        filmeRepository.delete(deletado);

    }


}
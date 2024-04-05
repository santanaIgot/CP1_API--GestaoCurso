package br.com.fiap.GestaoCurso.controller;

import br.com.fiap.GestaoCurso.dto.curso.CursoDetalheDto;
import br.com.fiap.GestaoCurso.model.Curso;
import br.com.fiap.GestaoCurso.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.GestaoCurso.dto.curso.CadastroCursoDto;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CursoDetalheDto> post(@RequestBody CadastroCursoDto dto, UriComponentsBuilder uriBuilder){
        var curso = new Curso(dto);
        cursoRepository.save(curso);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoDetalheDto(curso));
    }

}

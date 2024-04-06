package br.com.fiap.GestaoCurso.controller;

import br.com.fiap.GestaoCurso.dto.professor.CadastroProfessorDto;
import br.com.fiap.GestaoCurso.dto.professor.ProfessorDetalheDto;
import br.com.fiap.GestaoCurso.model.Professor;
import br.com.fiap.GestaoCurso.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<ProfessorDetalheDto> post (@RequestBody CadastroProfessorDto dto, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dto);
        professorRepository.save(professor);
        var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProfessorDetalheDto(professor));
    }

}

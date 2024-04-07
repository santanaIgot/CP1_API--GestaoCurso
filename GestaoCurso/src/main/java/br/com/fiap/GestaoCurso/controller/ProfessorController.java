package br.com.fiap.GestaoCurso.controller;

import br.com.fiap.GestaoCurso.dto.aluno.AlunoDetalheDto;
import br.com.fiap.GestaoCurso.dto.aluno.AtualizacaoAlunoDto;
import br.com.fiap.GestaoCurso.dto.aluno.ListagemAlunoDto;
import br.com.fiap.GestaoCurso.dto.professor.AtualizacaoProfessorDto;
import br.com.fiap.GestaoCurso.dto.professor.CadastroProfessorDto;
import br.com.fiap.GestaoCurso.dto.professor.ListagemProfessorDto;
import br.com.fiap.GestaoCurso.dto.professor.ProfessorDetalheDto;
import br.com.fiap.GestaoCurso.model.Professor;
import br.com.fiap.GestaoCurso.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class    ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<ProfessorDetalheDto> post (@RequestBody @Valid CadastroProfessorDto dto, UriComponentsBuilder uriBuilder){
        var professor = new Professor(dto);
        professorRepository.save(professor);
        var uri = uriBuilder.path("/professor/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProfessorDetalheDto(professor));
    }
    @GetMapping
    public ResponseEntity<List<ListagemProfessorDto>> listar(Pageable pageable){
        var  lista = professorRepository.findAll(pageable).stream().map(ListagemProfessorDto::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemProfessorDto> pesquisar(@PathVariable("id") Long id){
        var professor = professorRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemProfessorDto(professor));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <ProfessorDetalheDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoProfessorDto dto){
        var professor = professorRepository.getReferenceById(id);
        professor.atualizarDados(dto);
        return ResponseEntity.ok(new ProfessorDetalheDto(professor));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

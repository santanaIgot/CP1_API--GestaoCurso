package br.com.fiap.GestaoCurso.controller;


import br.com.fiap.GestaoCurso.dto.aluno.ListagemAlunoDto;
import br.com.fiap.GestaoCurso.dto.matricula.AtualizacaoMatriculaDto;
import br.com.fiap.GestaoCurso.dto.matricula.CadastroMatriculaDto;
import br.com.fiap.GestaoCurso.dto.matricula.ListagemMatriculaDto;
import br.com.fiap.GestaoCurso.dto.matricula.MatriculaDetalheDto;
import br.com.fiap.GestaoCurso.dto.professor.AtualizacaoProfessorDto;
import br.com.fiap.GestaoCurso.dto.professor.ProfessorDetalheDto;
import br.com.fiap.GestaoCurso.model.Matricula;
import br.com.fiap.GestaoCurso.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaRepository matriculaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<MatriculaDetalheDto> post(@RequestBody @Valid CadastroMatriculaDto dto, UriComponentsBuilder uriBuilder){
        var matricula = new Matricula(dto);
        matriculaRepository.save(matricula);
        var uri = uriBuilder.path("/matricula/{id}").buildAndExpand(matricula.getId()).toUri();

        return ResponseEntity.created(uri).body(new MatriculaDetalheDto(matricula));
    }


    @GetMapping
    public ResponseEntity<List<ListagemMatriculaDto>> listar(Pageable pageable){
        var lista = matriculaRepository.findAll(pageable).stream().map(ListagemMatriculaDto::new).toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemMatriculaDto> pesquisar(@PathVariable("id") Long id){
        var matricula = matriculaRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemMatriculaDto(matricula));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <MatriculaDetalheDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoMatriculaDto dto){
        var matricula = matriculaRepository.getReferenceById(id);
        matricula.atualizarDados(dto);
        return ResponseEntity.ok(new MatriculaDetalheDto(matricula));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        matriculaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

package br.com.fiap.GestaoCurso.controller;

import br.com.fiap.GestaoCurso.dto.aluno.ListagemAlunoDto;
import br.com.fiap.GestaoCurso.dto.curso.AtualizacaoCursoDto;
import br.com.fiap.GestaoCurso.dto.curso.CursoDetalheDto;
import br.com.fiap.GestaoCurso.dto.curso.ListagemCursoDto;
import br.com.fiap.GestaoCurso.model.Curso;
import br.com.fiap.GestaoCurso.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.GestaoCurso.dto.curso.CadastroCursoDto;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CursoDetalheDto> post(@RequestBody @Valid CadastroCursoDto dto, UriComponentsBuilder uriBuilder){
        var curso = new Curso(dto);
        cursoRepository.save(curso);
        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoDetalheDto(curso));
    }
    @GetMapping
    public ResponseEntity <List<ListagemCursoDto>> listar(Pageable pageable) {
        var lista = cursoRepository.findAll(pageable).stream().map(ListagemCursoDto:: new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemCursoDto> pesquisar(@PathVariable("id") Long id){
        var curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemCursoDto(curso));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<CursoDetalheDto> atualiza(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoCursoDto atualizacaoMercadoDto){
        var curso = cursoRepository.getReferenceById(id);
        curso.atualizaDados(atualizacaoMercadoDto);
        return ResponseEntity.ok(new CursoDetalheDto(curso));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

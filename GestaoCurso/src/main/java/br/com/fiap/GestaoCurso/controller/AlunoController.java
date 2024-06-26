package br.com.fiap.GestaoCurso.controller;


import br.com.fiap.GestaoCurso.dto.aluno.AlunoDetalheDto;
import br.com.fiap.GestaoCurso.dto.aluno.AtualizacaoAlunoDto;
import br.com.fiap.GestaoCurso.dto.aluno.ListagemAlunoDto;
import br.com.fiap.GestaoCurso.model.Aluno;
import br.com.fiap.GestaoCurso.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fiap.GestaoCurso.dto.aluno.CadastroAlunoDto;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDetalheDto> post(@RequestBody @Valid CadastroAlunoDto dto, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dto);
        alunoRepository.save(aluno);
        var uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new AlunoDetalheDto(aluno));
    }

    @GetMapping
    public ResponseEntity <List<ListagemAlunoDto>> listar(Pageable pageable) {
        var lista = alunoRepository.findAll(pageable).stream().map(ListagemAlunoDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListagemAlunoDto> pesquisar(@PathVariable("id") Long id){
        var aluno = alunoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ListagemAlunoDto(aluno));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity <AlunoDetalheDto> atualizar(@PathVariable("id") Long id, @RequestBody  @Valid AtualizacaoAlunoDto dto){
        var aluno = alunoRepository.getReferenceById(id);
        aluno.atualizarDados(dto);
        return ResponseEntity.ok(new AlunoDetalheDto(aluno));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

package br.com.fiap.GestaoCurso.controller;


import br.com.fiap.GestaoCurso.dto.curso.AtualizacaoCursoDto;
import br.com.fiap.GestaoCurso.dto.curso.CursoDetalheDto;
import br.com.fiap.GestaoCurso.dto.financeiro.AtualizacaoFinanceiroDto;
import br.com.fiap.GestaoCurso.dto.financeiro.CadastroFinanceiroDto;
import br.com.fiap.GestaoCurso.dto.financeiro.FinanceiroDetalheDto;
import br.com.fiap.GestaoCurso.dto.financeiro.ListagemFinanceiroDto;
import br.com.fiap.GestaoCurso.model.Financeiro;
import br.com.fiap.GestaoCurso.repository.FinanceiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {
    @Autowired
    private FinanceiroRepository financeiroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<FinanceiroDetalheDto> post(@RequestBody CadastroFinanceiroDto dto, UriComponentsBuilder uriBuilder){
        var financeiro = new Financeiro(dto);
        financeiroRepository.save(financeiro);

        var uri = uriBuilder.path("/financerio/{id}").buildAndExpand(financeiro.getId()).toUri();

        return ResponseEntity.created(uri).body(new FinanceiroDetalheDto(financeiro));
    }

    @GetMapping
    public ResponseEntity<List<ListagemFinanceiroDto>> lista(Pageable pageable){
        var lista = financeiroRepository.findAll(pageable).stream().map(ListagemFinanceiroDto :: new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<FinanceiroDetalheDto> atualiza(@PathVariable("id") Long id, @RequestBody AtualizacaoFinanceiroDto atualizacaoFinanceiroDto){
        var financeiro = financeiroRepository.getReferenceById(id);
        financeiro.atualizaDados(atualizacaoFinanceiroDto);
        return ResponseEntity.ok(new FinanceiroDetalheDto(financeiro));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        financeiroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

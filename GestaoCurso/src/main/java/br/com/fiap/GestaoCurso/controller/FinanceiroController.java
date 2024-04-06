package br.com.fiap.GestaoCurso.controller;


import br.com.fiap.GestaoCurso.dto.financeiro.CadastroFinanceiroDto;
import br.com.fiap.GestaoCurso.dto.financeiro.FinanceiroDetalheDto;
import br.com.fiap.GestaoCurso.model.Financeiro;
import br.com.fiap.GestaoCurso.repository.FinanceiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {
    @Autowired
    FinanceiroRepository financeiroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<FinanceiroDetalheDto> post(@RequestBody CadastroFinanceiroDto dto, UriComponentsBuilder uriBuilder){
        var financeiro = new Financeiro(dto);
        financeiroRepository.save(financeiro);

        var uri = uriBuilder.path("/financerio/{id}").buildAndExpand(financeiro.getId()).toUri();

        return ResponseEntity.created(uri).body(new FinanceiroDetalheDto(financeiro));
    }
}

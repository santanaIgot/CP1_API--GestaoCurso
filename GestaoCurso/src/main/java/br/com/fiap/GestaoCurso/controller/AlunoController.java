package br.com.fiap.GestaoCurso.controller;


import br.com.fiap.GestaoCurso.dto.aluno.AlunoDetalheDto;
import br.com.fiap.GestaoCurso.model.Aluno;
import br.com.fiap.GestaoCurso.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fiap.GestaoCurso.dto.aluno.CadastroAlunoDto;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<AlunoDetalheDto> post(@RequestBody CadastroAlunoDto dto, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dto);
        alunoRepository.save(aluno);
        var uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new AlunoDetalheDto(aluno));
    }

}

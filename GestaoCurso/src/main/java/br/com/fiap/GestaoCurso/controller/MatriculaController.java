package br.com.fiap.GestaoCurso.controller;


import br.com.fiap.GestaoCurso.dto.matricula.CadastroMatriculaDto;
import br.com.fiap.GestaoCurso.dto.matricula.MatriculaDetalheDto;
import br.com.fiap.GestaoCurso.model.Matricula;
import br.com.fiap.GestaoCurso.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    MatriculaRepository matriculaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<MatriculaDetalheDto> post(@RequestBody CadastroMatriculaDto dto, UriComponentsBuilder uriBuilder){
        var matricula = new Matricula(dto);
        matriculaRepository.save(matricula);
        var uri = uriBuilder.path("/matricula/{id}").buildAndExpand(matricula.getId()).toUri();

        return ResponseEntity.created(uri).body(new MatriculaDetalheDto(matricula));
    }

}

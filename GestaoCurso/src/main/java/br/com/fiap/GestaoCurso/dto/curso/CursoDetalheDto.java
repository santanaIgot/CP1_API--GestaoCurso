package br.com.fiap.GestaoCurso.dto.curso;

import br.com.fiap.GestaoCurso.model.Curso;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CursoDetalheDto(Long id, String curso, String descricao, LocalDateTime dataCadastroCurso, Long professor) {

    public CursoDetalheDto(Curso curso) {
        this(curso.getId(),curso.getCurso(),curso.getDescricao(),curso.getDataCadastroCurso() ,curso.getProfessor());
    }

}

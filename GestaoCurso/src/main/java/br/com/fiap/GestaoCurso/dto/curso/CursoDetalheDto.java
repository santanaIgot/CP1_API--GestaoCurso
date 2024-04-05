package br.com.fiap.GestaoCurso.dto.curso;

import br.com.fiap.GestaoCurso.model.Curso;

import java.time.LocalDate;

public record CursoDetalheDto(Long id, String curso, String descricao,
                              LocalDate dataCadastroCurso, String professor) {

    public CursoDetalheDto(Curso curso) {

        this(curso.getId(),curso.getDescricao(), curso.getCurso(),curso.getDataCadastroCurso() ,curso.getProfessor());
    }

}

package br.com.fiap.GestaoCurso.dto.curso;

import br.com.fiap.GestaoCurso.model.Curso;

import java.time.LocalDateTime;

public record ListagemCursoDto(Long id, String curso, String descricao, LocalDateTime dataCadastroCurso, Long professor) {

    public ListagemCursoDto(Curso curso){
        this(curso.getId(),curso.getCurso(),curso.getDescricao(),curso.getDataCadastroCurso(),curso.getProfessor());
    }

}

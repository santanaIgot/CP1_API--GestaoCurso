package br.com.fiap.GestaoCurso.dto.matricula;

import br.com.fiap.GestaoCurso.model.Matricula;

import java.time.LocalDateTime;

public record ListagemMatriculaDto(Long id, Long codigoAluno, Long codigoCurso, LocalDateTime dataMatricula, Long rm) {
    public ListagemMatriculaDto(Matricula matricula){
        this(matricula.getId(), matricula.getCodigoAluno(), matricula.getCodigoCurso(),
                matricula.getDataMatricula(),matricula.getRm());
    }
}

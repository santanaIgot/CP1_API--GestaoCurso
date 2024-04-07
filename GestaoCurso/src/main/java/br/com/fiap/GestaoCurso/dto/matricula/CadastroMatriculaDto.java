package br.com.fiap.GestaoCurso.dto.matricula;

import java.time.LocalDateTime;

public record CadastroMatriculaDto(Long id, Long codigoAluno, Long codigoCurso, LocalDateTime dataMatricula,
                                   Long rm) {
}

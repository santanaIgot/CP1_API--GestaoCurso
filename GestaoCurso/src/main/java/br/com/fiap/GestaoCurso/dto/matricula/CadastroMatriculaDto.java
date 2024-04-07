package br.com.fiap.GestaoCurso.dto.matricula;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CadastroMatriculaDto(
        @NotNull(message = "Id do aluno é obrigatório!")
        Long codigoAluno,
        @NotNull(message = "Id do curso é obrigatório!")
        Long codigoCurso,
        @NotNull(message = "rm é obrigatório!")
        Long rm) {
}

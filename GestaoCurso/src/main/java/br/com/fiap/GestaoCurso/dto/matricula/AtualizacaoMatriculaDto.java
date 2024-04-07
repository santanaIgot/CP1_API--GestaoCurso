package br.com.fiap.GestaoCurso.dto.matricula;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AtualizacaoMatriculaDto(
        @NotNull(message = "Id do curso é obrigatório!")
        Long codigoCurso
) {
}

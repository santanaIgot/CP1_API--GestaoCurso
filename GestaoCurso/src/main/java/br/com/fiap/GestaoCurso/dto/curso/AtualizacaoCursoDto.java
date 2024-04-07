package br.com.fiap.GestaoCurso.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AtualizacaoCursoDto(
        @NotBlank
        @Size(max = 60, min =5)
        String curso,
        @NotBlank
        @Size(max = 200, min = 5)
        String descricao,
        @NotBlank
        @Size(min = 5, max = 100)
        String professor) {
}

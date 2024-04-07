package br.com.fiap.GestaoCurso.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CadastroCursoDto(
        @NotBlank
        @Size(max = 60, min =5)
         String curso,
         @NotBlank
         @Size(max = 200, min = 5)
         String descricao,
         @NotNull
         Long professor) {
}

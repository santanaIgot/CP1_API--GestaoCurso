package br.com.fiap.GestaoCurso.dto.professor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AtualizacaoProfessorDto(
        @NotBlank()
        @Size(max = 100, min = 3 , message = "O nome deve ter no mínimo 3 caracteres.")
        String nome,
        @NotNull
        @Size(max = 30, min = 5, message = "O nome da matéria deve ter no mínimmo 5 caracteres." )
        String materia) {
}

package br.com.fiap.GestaoCurso.dto.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizacaoAlunoDto(
        @NotBlank
        @Size(max = 100, min = 3, message = "O nome deve conter no mínimo 3 caracteres e no máximo 100.")
        String nome,
        @NotBlank
        @Size(max = 100, min = 10, message = "O email deve ter no mínimo 10 caracteres e no máximo 100.")
        String email,
        @Past(message = "A data de nascimento deve estar no passado!")
        @NotNull
        LocalDate dataNascimento,
        @NotBlank
        @Size(max = 11, min = 11, message = "O telefone deve conter no 11 caracteres.")
        String telefone)  {

}

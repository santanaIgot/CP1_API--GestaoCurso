package br.com.fiap.GestaoCurso.dto.aluno;

import java.time.LocalDate;

public record CadastroAlunoDto(String nome, String email, LocalDate dataNascimento) {

}

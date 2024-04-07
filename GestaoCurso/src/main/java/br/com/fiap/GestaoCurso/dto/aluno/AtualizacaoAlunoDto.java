package br.com.fiap.GestaoCurso.dto.aluno;

import java.time.LocalDate;

public record AtualizacaoAlunoDto(String nome, String email, LocalDate dataNascimento, String telefone) {

}

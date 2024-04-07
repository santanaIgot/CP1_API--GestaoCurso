package br.com.fiap.GestaoCurso.dto.aluno;

import br.com.fiap.GestaoCurso.model.Aluno;

import java.time.LocalDate;

public record ListagemAlunoDto(Long id, String nome, LocalDate dataNascimento, String email, String telefone) {

    public ListagemAlunoDto(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getDataNascimento(), aluno.getEmail(), aluno.getTelefone());
    }

}

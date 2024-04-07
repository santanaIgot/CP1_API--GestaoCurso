package br.com.fiap.GestaoCurso.dto.professor;

import br.com.fiap.GestaoCurso.model.Professor;

public record ListagemProfessorDto(String nome, String materia) {

    public ListagemProfessorDto(Professor professor){
        this(professor.getNome(), professor.getMateria());
    }
}

package br.com.fiap.GestaoCurso.dto.professor;

import br.com.fiap.GestaoCurso.model.Professor;

public record ListagemProfessorDto(Long id, String nome, String materia) {

    public ListagemProfessorDto(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getMateria());
    }
}

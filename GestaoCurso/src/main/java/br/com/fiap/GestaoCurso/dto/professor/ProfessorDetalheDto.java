package br.com.fiap.GestaoCurso.dto.professor;

import br.com.fiap.GestaoCurso.model.Professor;

public record ProfessorDetalheDto(String nome, String materia) {

    public ProfessorDetalheDto(Professor professor){
        this(professor.getNome(), professor.getMateria());
    }

}

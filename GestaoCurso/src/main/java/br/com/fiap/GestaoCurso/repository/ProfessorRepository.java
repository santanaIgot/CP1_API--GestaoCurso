package br.com.fiap.GestaoCurso.repository;

import br.com.fiap.GestaoCurso.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

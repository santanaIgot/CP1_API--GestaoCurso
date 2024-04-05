package br.com.fiap.GestaoCurso.repository;

import br.com.fiap.GestaoCurso.model.Aluno;
import br.com.fiap.GestaoCurso.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {}

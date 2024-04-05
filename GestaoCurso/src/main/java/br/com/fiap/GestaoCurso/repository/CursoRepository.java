package br.com.fiap.GestaoCurso.repository;

import br.com.fiap.GestaoCurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}

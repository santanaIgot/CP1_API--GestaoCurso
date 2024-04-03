package br.com.fiap.GestaoCurso.repository;

import br.com.fiap.GestaoCurso.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

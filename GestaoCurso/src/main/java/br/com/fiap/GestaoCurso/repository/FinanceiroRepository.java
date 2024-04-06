package br.com.fiap.GestaoCurso.repository;

import br.com.fiap.GestaoCurso.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceiroRepository  extends JpaRepository<Financeiro, Long> { }

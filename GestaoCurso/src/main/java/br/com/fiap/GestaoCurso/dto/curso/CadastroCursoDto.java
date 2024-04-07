package br.com.fiap.GestaoCurso.dto.curso;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CadastroCursoDto(Long id, String curso, String descricao, LocalDateTime dataCadastroCurso, String professor) {
}

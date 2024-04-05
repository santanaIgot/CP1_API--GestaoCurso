package br.com.fiap.GestaoCurso.dto.curso;

import java.time.LocalDate;

public record CadastroCursoDto(Long id, String curso, String descricao,
                               LocalDate dataCadastroCurso, String professor) {
}

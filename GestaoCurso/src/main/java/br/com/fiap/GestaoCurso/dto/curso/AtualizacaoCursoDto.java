package br.com.fiap.GestaoCurso.dto.curso;

import java.time.LocalDateTime;

public record AtualizacaoCursoDto(String curso, String descricao, String professor) {
}

package br.com.fiap.GestaoCurso.dto.financeiro;

import br.com.fiap.GestaoCurso.model.TipoPagamento;

public record CadastroFinanceiroDto(Long id, Long codigoAluno , TipoPagamento pagamento) {
}

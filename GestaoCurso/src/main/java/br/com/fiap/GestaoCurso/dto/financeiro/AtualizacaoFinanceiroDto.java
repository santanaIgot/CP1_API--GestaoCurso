package br.com.fiap.GestaoCurso.dto.financeiro;

import br.com.fiap.GestaoCurso.model.TipoPagamento;

public record AtualizacaoFinanceiroDto(Long codigoAluno , TipoPagamento pagamento) {
}

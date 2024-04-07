package br.com.fiap.GestaoCurso.dto.financeiro;

import br.com.fiap.GestaoCurso.model.Financeiro;
import br.com.fiap.GestaoCurso.model.TipoPagamento;

public record FinanceiroDetalheDto(Long id,Long codigoAluno, TipoPagamento pagamento) {
    public FinanceiroDetalheDto(Financeiro financeiro) {
        this(financeiro.getId(),financeiro.getCodigoAluno(), financeiro.getPagamento());
    }
}

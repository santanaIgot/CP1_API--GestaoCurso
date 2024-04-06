package br.com.fiap.GestaoCurso.dto.financeiro;

import br.com.fiap.GestaoCurso.model.Financeiro;

public record FinanceiroDetalheDto(Long id,Long codigoAluno, String tipoPagamento) {
    public FinanceiroDetalheDto(Financeiro financeiro) {
        this(financeiro.getId(),financeiro.getCodigoAluno(), financeiro.getTipoPagamento());
    }
}

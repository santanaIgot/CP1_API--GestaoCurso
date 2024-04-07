package br.com.fiap.GestaoCurso.dto.financeiro;

import br.com.fiap.GestaoCurso.model.Financeiro;
import br.com.fiap.GestaoCurso.model.TipoPagamento;

public record ListagemFinanceiroDto(Long id, Long codigoAluno, TipoPagamento pagamento) {

    public ListagemFinanceiroDto(Financeiro financeiro){
        this(financeiro.getId(), financeiro.getCodigoAluno(), financeiro.getPagamento());
    }

}

package br.com.fiap.GestaoCurso.dto.financeiro;

import br.com.fiap.GestaoCurso.model.TipoPagamento;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoFinanceiroDto(
        @NotNull(message = "Tipo de pagamento é obrigatório")
        TipoPagamento pagamento)  {
}

package br.com.fiap.GestaoCurso.model;


import br.com.fiap.GestaoCurso.dto.financeiro.AtualizacaoFinanceiroDto;
import br.com.fiap.GestaoCurso.dto.financeiro.CadastroFinanceiroDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter@Setter

@Entity
@Table(name = "Financeiro_cp1_java")

public class Financeiro {

    @Id
    @GeneratedValue
        @Column(name="cd_financeiro")
    private Long id;

    @Column(name = "cd_aluno", nullable = false)
    private Long codigoAluno;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_pagamento", nullable = false, length = 100)
    private TipoPagamento pagamento;

    public Financeiro(CadastroFinanceiroDto dto) {
        codigoAluno = dto.codigoAluno();
        pagamento = dto.pagamento();

    }

    public void atualizaDados(AtualizacaoFinanceiroDto atualizacaoFinanceiroDto) {
        if(atualizacaoFinanceiroDto.pagamento() != null){
            pagamento = atualizacaoFinanceiroDto.pagamento();
        }
    }
}

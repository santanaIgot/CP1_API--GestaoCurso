package br.com.fiap.GestaoCurso.model;


import br.com.fiap.GestaoCurso.dto.curso.AtualizacaoCursoDto;
import br.com.fiap.GestaoCurso.dto.curso.CadastroCursoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "Curso_cp1_java")
@EntityListeners(AuditingEntityListener.class)
public class Curso {
    @Id
    @GeneratedValue

    @Column(name="cd_codigo")
    private Long id;

    @Column(name="nm_curso",nullable = false)
    private String curso;

    @Column(name="dc_curso",nullable = false)
    private String descricao;

    @Column(name="dt_cadastro")
    @CreatedDate
    private LocalDateTime dataCadastroCurso;

    @Column(name = "nm_prof", nullable = false)
    private String professor;

    public Curso(CadastroCursoDto dto) {
        id = dto.id();
        curso = dto.curso();
        descricao = dto.descricao();
        dataCadastroCurso = dto.dataCadastroCurso();
        professor = dto.professor();


    }

    public void atualizaDados(AtualizacaoCursoDto atualizacaoMercadoDto) {
        if(atualizacaoMercadoDto.curso() != null){
            curso = atualizacaoMercadoDto.curso();
        }
        if(atualizacaoMercadoDto.descricao() != null){
            descricao = atualizacaoMercadoDto.descricao();
        }
        if(atualizacaoMercadoDto.professor() != null){
            professor= atualizacaoMercadoDto.professor();
        }
    }
}

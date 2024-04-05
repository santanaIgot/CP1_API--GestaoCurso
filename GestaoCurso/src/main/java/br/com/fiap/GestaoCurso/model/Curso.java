package br.com.fiap.GestaoCurso.model;


import br.com.fiap.GestaoCurso.dto.curso.CadastroCursoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
@Entity
public class Curso {
    @Id
    @GeneratedValue

    @Column(name="cd_codigo")
    private Long id;
    @Column(name="nm_curso")
    private String curso;
    @Column(name="desc")
    private String descricao;
    @Column(name="dt_cadastro")
    private LocalDate dataCadastroCurso;
    @Column(name = "nm_prof")
    private String professor;

    public Curso(CadastroCursoDto dto) {
        id = dto.id();
        curso = dto.curso();
        descricao = dto.descricao();
        dataCadastroCurso = dto.dataCadastroCurso();
        professor = dto.professor();


    }
}

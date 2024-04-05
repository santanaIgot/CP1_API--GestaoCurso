package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.matricula.CadastroMatriculaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "Matricula_cp1_java")
@EntityListeners(AuditingEntityListener.class)
public class Matricula {

    @Id
    @GeneratedValue
    @Column(name = "cd_matricula")
    private Long id;

    @Column(name = "cd_aluno")
    private Long codigoAluno;

    @Column(name = "cd_curso")
    private Long codigoCurso;

    @Column(name = "dt_matricula")
    @CreatedDate
    private LocalDateTime dataMatricula;

    @Column(name = "nr_rm")
    private Long rm;

    public Matricula(CadastroMatriculaDto dto) {
        id = dto.id();
        codigoAluno = dto.codigoAluno();
        codigoCurso = dto.codigoCurso();
        dataMatricula = dto.dataMatricula();
        rm = dto.rm();
    }
}

package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.matricula.CadastroMatriculaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "Matricula_cp1_java")
public class Matricula {
    @Id
    @GeneratedValue
    @Column(name = "cd_matricula", nullable = false)
    private Long id;

    @Column(name = "cd_aluno", nullable = false)
    private Long codigoAluno;

    @Column(name = "cd_curso", nullable = false)
    private Long codigoCurso;

    @Column(name = "dt_matricula")
    private LocalDateTime dataMatricula;

    @Column(name = "nr_rm", nullable = false)
    private Long rm;

    public Matricula(CadastroMatriculaDto dto) {
        id = dto.id();
        codigoAluno = dto.codigoAluno();
        codigoCurso = dto.codigoCurso();
        dataMatricula = dto.dataMatricula();
        rm = dto.rm();
    }
}

package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.matricula.AtualizacaoMatriculaDto;
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
    @Column(name = "cd_matricula", nullable = false)
    private Long id;

    @Column(name = "cd_aluno", nullable = false)
    private Long codigoAluno;

    @Column(name = "cd_curso", nullable = false)
    private Long codigoCurso;

    @Column(name = "dt_matricula")
    @CreatedDate
    private LocalDateTime dataMatricula;

    @Column(name = "nr_rm", nullable = false)
    private Long rm;

    public Matricula(CadastroMatriculaDto dto) {
        codigoAluno = dto.codigoAluno();
        codigoCurso = dto.codigoCurso();
        rm = dto.rm();
    }

    public void atualizarDados(AtualizacaoMatriculaDto dto) {
        if(dto.codigoCurso() != null){
            codigoCurso = dto.codigoCurso();
        }
    }
}

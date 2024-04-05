package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.aluno.CadastroAlunoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "Aluno_cp1_java")
@Getter@Setter
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue
    @Column(name = "cd_codigo")
    private Long id ;

    @Column(name = "nm_cliente", length = 100)
    private String nome;

    @Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "numero")
    private String telefone;

    public Aluno(CadastroAlunoDto dto){
        nome = dto.nome();
        email = dto.email();
        dataNascimento = dto.dataNascimento();
        telefone = dto.telefone();
    }
}

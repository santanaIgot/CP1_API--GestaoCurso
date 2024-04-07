package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.aluno.AtualizacaoAlunoDto;
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

    @Column(name = "nm_cliente", length = 100, nullable = false)
    private String nome;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nm_email", nullable = false, length = 100)
    private String email;

    @Column(name = "nr_numero", nullable = false, length=11)
    private String telefone;

    public Aluno(CadastroAlunoDto dto){
        nome = dto.nome();
        email = dto.email();
        dataNascimento = dto.dataNascimento();
        telefone = dto.telefone();
    }

    public void atualizarDados(AtualizacaoAlunoDto dto){
        if(dto.nome() != null)
            nome = dto.nome();
        if(dto.dataNascimento() != null)
            dataNascimento = dto.dataNascimento();
        if(dto.email() != null)
            email = dto.email();
        if(dto.telefone() != null)
            telefone = dto.telefone();
    }
}

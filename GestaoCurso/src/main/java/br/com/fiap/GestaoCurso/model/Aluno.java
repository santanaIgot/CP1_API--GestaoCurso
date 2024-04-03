package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.aluno.CadastroAlunoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    Long id ;
    String nome;
    LocalDate dataNascimento;
    String email;
    int telefone;

    public Aluno(CadastroAlunoDto dto){
        nome = dto.nome();
        email = dto.email();
        dataNascimento = dto.dataNascimento();
    }
}

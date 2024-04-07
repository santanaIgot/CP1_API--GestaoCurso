package br.com.fiap.GestaoCurso.model;

import br.com.fiap.GestaoCurso.dto.professor.AtualizacaoProfessorDto;
import br.com.fiap.GestaoCurso.dto.professor.CadastroProfessorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "Professor_cp1_java")
public class Professor {


    @GeneratedValue
    @Id
    @Column(name = "cd_professor")
    private Long id;

    @Column(name = "nm_professor", nullable = false, length = 100)
    private String nome;

    @Column(name = "nm_materia", nullable = false, length = 30)
    private String materia;


    public Professor(CadastroProfessorDto dto){
        nome = dto.nome();
        materia = dto.materia();
    }

    public void atualizarDados(AtualizacaoProfessorDto dto) {
        if(dto.nome() != null){
            nome = dto.nome();
        }
        if(dto.materia() != null){
            materia = dto.materia();
        }
    }
}

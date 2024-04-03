package br.com.fiap.GestaoCurso.dto.aluno;

        import br.com.fiap.GestaoCurso.model.Aluno;
        import java.time.LocalDate;

public record AlunoDetalheDto(Long id, String nome, LocalDate  dataNascimento, String email, int telefone) {

    public AlunoDetalheDto(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getDataNascimento(), aluno.getEmail(), aluno.getTelefone());
    }
}

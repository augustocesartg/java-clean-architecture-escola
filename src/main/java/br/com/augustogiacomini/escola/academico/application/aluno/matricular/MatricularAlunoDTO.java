package br.com.augustogiacomini.escola.application.aluno.matricular;

import br.com.augustogiacomini.escola.domain.aluno.Aluno;
import br.com.augustogiacomini.escola.domain.aluno.Cpf;
import br.com.augustogiacomini.escola.domain.aluno.Email;

public class MatricularAlunoDTO {

    private String nomeAluno;

    private String cpfAluno;

    private String emailAluno;

    public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new Cpf(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}

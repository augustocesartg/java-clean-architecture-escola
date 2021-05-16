package br.com.augustogiacomini.escola.application.aluno.matricular;

import br.com.augustogiacomini.escola.domain.aluno.Aluno;
import br.com.augustogiacomini.escola.domain.aluno.AlunoRepository;

public class MatricularAluno {

    private AlunoRepository repository;

    public MatricularAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void executa(MatricularAlunoDTO dados) {
        Aluno aluno = dados.criarAluno();
        repository.matricular(aluno);
    }
}

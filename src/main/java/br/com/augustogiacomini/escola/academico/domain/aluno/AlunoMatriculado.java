package br.com.augustogiacomini.escola.domain.aluno;

import br.com.augustogiacomini.escola.domain.Evento;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final Cpf cpfAluno;

    private final LocalDateTime momento;

    public AlunoMatriculado(Cpf cpfAluno) {
        this.cpfAluno = cpfAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public Cpf getCpfAluno() {
        return cpfAluno;
    }
}

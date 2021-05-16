package br.com.augustogiacomini.escola.academico.domain.selo;

import br.com.augustogiacomini.escola.academico.domain.aluno.Cpf;

public class Selo {

    private Cpf cpfAluno;

    private String nome;

    public Selo(Cpf cpfAluno, String nome) {
        this.cpfAluno = cpfAluno;
        this.nome = nome;
    }

    public Cpf getCpfAluno() {
        return cpfAluno;
    }

    public String getNome() {
        return nome;
    }
}

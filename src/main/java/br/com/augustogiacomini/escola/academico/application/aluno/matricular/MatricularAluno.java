package br.com.augustogiacomini.escola.application.aluno.matricular;

import br.com.augustogiacomini.escola.domain.PublicadorDeEventos;
import br.com.augustogiacomini.escola.domain.aluno.Aluno;
import br.com.augustogiacomini.escola.domain.aluno.AlunoMatriculado;
import br.com.augustogiacomini.escola.domain.aluno.AlunoRepository;

public class MatricularAluno {

    private final AlunoRepository repository;

    private final PublicadorDeEventos publicador;

    public MatricularAluno(AlunoRepository repository, PublicadorDeEventos publicador) {
        this.repository = repository;
        this.publicador = publicador;
    }

    public void executa(MatricularAlunoDTO dados) {
        Aluno aluno = dados.criarAluno();
        repository.matricular(aluno);

        AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
        publicador.publicar(evento);
    }
}

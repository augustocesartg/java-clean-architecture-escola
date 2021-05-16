package br.com.augustogiacomini.escola.academico;

import br.com.augustogiacomini.escola.gamificacao.application.GeraSeloAlunoNovato;
import br.com.augustogiacomini.escola.shared.domain.evento.PublicadorDeEventos;
import br.com.augustogiacomini.escola.academico.domain.aluno.AlunoRepository;
import br.com.augustogiacomini.escola.academico.domain.aluno.LogAlunoMatriculado;
import br.com.augustogiacomini.escola.academico.infra.aluno.AlunoRepositoryMemory;
import br.com.augustogiacomini.escola.academico.application.aluno.matricular.MatricularAluno;
import br.com.augustogiacomini.escola.academico.application.aluno.matricular.MatricularAlunoDTO;

public class MatricularAlunoMain {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-10";
        String email = "fulano@email.com";

        AlunoRepository repository = new AlunoRepositoryMemory();

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogAlunoMatriculado());

        MatricularAluno matricularAluno = new MatricularAluno(repository, publicador);
        matricularAluno.executa(new MatricularAlunoDTO(nome, cpf, email));
    }
}

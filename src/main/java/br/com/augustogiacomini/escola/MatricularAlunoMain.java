package br.com.augustogiacomini.escola;

import br.com.augustogiacomini.escola.application.aluno.matricular.MatricularAluno;
import br.com.augustogiacomini.escola.application.aluno.matricular.MatricularAlunoDTO;
import br.com.augustogiacomini.escola.infra.aluno.AlunoRepositoryMemory;

public class MatricularAlunoMain {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-10";
        String email = "fulano@email.com";

        MatricularAluno matricularAluno = new MatricularAluno(new AlunoRepositoryMemory());
        matricularAluno.executa(new MatricularAlunoDTO(nome, cpf, email));
    }
}

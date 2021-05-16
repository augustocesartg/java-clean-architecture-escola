package br.com.augustogiacomini.escola.domain.aluno;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCpf(Cpf cpf);

    List<Aluno> listarTodosAlunosMatriculados();
}

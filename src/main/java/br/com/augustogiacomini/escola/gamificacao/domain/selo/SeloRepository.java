package br.com.augustogiacomini.escola.academico.domain.selo;

import br.com.augustogiacomini.escola.academico.domain.aluno.Cpf;

import java.util.List;

public interface SeloRepository {

    void adicionar(Selo selo);

    List<Selo> buscarSelosDoAlunoPorCpf(Cpf cpf);
}

package br.com.augustogiacomini.escola.infra.aluno;

import br.com.augustogiacomini.escola.domain.aluno.Aluno;
import br.com.augustogiacomini.escola.domain.aluno.Cpf;
import br.com.augustogiacomini.escola.domain.aluno.AlunoNotFoundException;
import br.com.augustogiacomini.escola.domain.aluno.AlunoRepository;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryMemory implements AlunoRepository {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        return matriculados.stream()
                .filter(alunoMatriculado -> alunoMatriculado.getCpf().toString().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNotFoundException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}

package br.com.augustogiacomini.escola.academico.infra.selo;

import br.com.augustogiacomini.escola.academico.domain.aluno.Cpf;
import br.com.augustogiacomini.escola.academico.domain.selo.Selo;
import br.com.augustogiacomini.escola.academico.domain.selo.SeloRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeloRepositoryMemory implements SeloRepository {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> buscarSelosDoAlunoPorCpf(Cpf cpf) {
        return this.selos.stream()
                .filter(s -> s.getCpfAluno().toString().equals(cpf.toString()))
                .collect(Collectors.toList());
    }
}

package br.com.augustogiacomini.escola.application.aluno.matricular;

import br.com.augustogiacomini.escola.domain.aluno.Aluno;
import br.com.augustogiacomini.escola.domain.aluno.Cpf;
import br.com.augustogiacomini.escola.infra.aluno.AlunoRepositoryMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    @Test
    void devePersistirAluno() {
        AlunoRepositoryMemory repository = new AlunoRepositoryMemory();
        MatricularAluno useCase = new MatricularAluno(repository);

        MatricularAlunoDTO dto =
                new MatricularAlunoDTO("Fulano", "123.456.789-10", "fulano@email.com");
        useCase.executa(dto);

        Aluno aluno = repository.buscarPorCpf(new Cpf("123.456.789-10"));

        assertEquals("Fulano", aluno.getNome());
        assertEquals("123.456.789-10", aluno.getCpf());
        assertEquals("fulano@email.com", aluno.getEmail());
    }
}

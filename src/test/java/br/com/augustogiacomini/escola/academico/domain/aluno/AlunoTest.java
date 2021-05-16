package br.com.augustogiacomini.escola.domain.aluno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void beforeEach() {
        this.aluno = new Aluno(
                new Cpf("123.456.789-10"),
                "Fulano da Silva",
                new Email("fulano@email.com")
        );
    }

    @Test
    void deveAdicionar1TelefoneParaOAluno() {
        aluno.adicionarTelefone("46", "999170455");

        assertEquals(1, aluno.getTelefones().size());
    }

    @Test
    void deveAdicionar2TelefoneParaOAluno() {
        aluno.adicionarTelefone("46", "999170455");
        aluno.adicionarTelefone("46", "999170444");

        assertEquals(2, aluno.getTelefones().size());
    }

    @Test
    void naoDeveAdicionar3TelefoneParaOAlunoMaximoAtingido() {
        assertThrows(AlunoMaxPhonesException.class, () -> {
            aluno.adicionarTelefone("46", "999170455");
            aluno.adicionarTelefone("46", "999170444");
            aluno.adicionarTelefone("46", "999170433");
        });
    }
}

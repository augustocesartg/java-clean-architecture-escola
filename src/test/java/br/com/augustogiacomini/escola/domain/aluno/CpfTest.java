package br.com.augustogiacomini.escola.domain.aluno;

import br.com.augustogiacomini.escola.domain.aluno.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void naoDeveCriarCpfsComNumerosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class, () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("000.000.000-0"));
    }

    @Test
    void dveCriarCpfsComNumerosValidos() {
        String numero = "752.585.280-49";

        Cpf cpf = new Cpf(numero);

        assertNotNull(cpf);
        assertEquals(numero, cpf.getNumero());
    }
}

package br.com.augustogiacomini.escola.domain.aluno;

import br.com.augustogiacomini.escola.domain.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void naoDeveCriarTelefonesComDddsInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "999170455"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", "999170455"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("0", "999170455"));
    }

    @Test
    void naoDeveCriarTelefonesComNumerosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("46", "9991704"));
    }

    @Test
    void dveCriarTelefonesComDddsENumerosValidos() {
        String ddd = "46";
        String numero = "999170455";

        Telefone telefone = new Telefone(ddd, numero);

        assertNotNull(telefone);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }
}

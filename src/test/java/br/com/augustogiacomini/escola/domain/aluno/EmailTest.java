package br.com.augustogiacomini.escola.domain.aluno;

import br.com.augustogiacomini.escola.domain.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void naoDeveCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    void dveCriarEmailsComEnderecosValidos() {
        String endereco = "augustocesartg@gmail.com";

        Email email = new Email(endereco);

        assertNotNull(email);
        assertEquals(endereco, email.getEndereco());
    }
}

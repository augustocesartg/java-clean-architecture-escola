package br.com.augustogiacomini.escola.domain.aluno;

public interface PasswordEncrypt {

    String encrypt(String password);

    boolean isValid(String passwordEncrypted, String password);
}

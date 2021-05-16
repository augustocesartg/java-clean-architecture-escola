package br.com.augustogiacomini.escola.domain.aluno;

public class AlunoMaxPhonesException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public AlunoMaxPhonesException(int maxPhones) {
        super("Número máximo de telefones já foi atingido! Máximo: " + maxPhones);
    }
}

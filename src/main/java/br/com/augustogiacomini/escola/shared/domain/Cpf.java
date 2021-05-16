package br.com.augustogiacomini.escola.academico.domain.aluno;

public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if (numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido!");
        }

        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}

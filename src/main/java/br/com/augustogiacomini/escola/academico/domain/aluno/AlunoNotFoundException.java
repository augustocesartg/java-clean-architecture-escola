package br.com.augustogiacomini.escola.domain.aluno;

public class AlunoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNotFoundException(Cpf cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getNumero());
    }
}

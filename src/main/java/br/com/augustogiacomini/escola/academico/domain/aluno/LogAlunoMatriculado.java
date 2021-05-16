package br.com.augustogiacomini.escola.domain.aluno;

import br.com.augustogiacomini.escola.domain.Evento;
import br.com.augustogiacomini.escola.domain.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        Cpf cpf = ((AlunoMatriculado) evento).getCpfAluno();

        System.out.println(String.format("Aluno com CPF %s matriculado em %s", cpf, momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}

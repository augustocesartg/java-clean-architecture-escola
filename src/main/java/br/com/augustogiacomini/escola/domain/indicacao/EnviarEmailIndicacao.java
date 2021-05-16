package br.com.augustogiacomini.escola.domain.indicacao;

import br.com.augustogiacomini.escola.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);
}

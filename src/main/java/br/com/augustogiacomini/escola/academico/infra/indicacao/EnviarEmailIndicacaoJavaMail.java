package br.com.augustogiacomini.escola.infra.indicacao;

import br.com.augustogiacomini.escola.domain.indicacao.EnviarEmailIndicacao;
import br.com.augustogiacomini.escola.domain.aluno.Aluno;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviarEmailIndicacaoJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("admin@escola.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(indicado.getEmail()));
            msg.setSubject("Indicação de aluno");
            msg.setText("Você foi indicado para participar do nossos cursos!");
            Transport.send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

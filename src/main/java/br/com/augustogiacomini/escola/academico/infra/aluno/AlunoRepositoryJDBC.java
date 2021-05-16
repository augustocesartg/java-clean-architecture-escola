package br.com.augustogiacomini.escola.infra.aluno;

import br.com.augustogiacomini.escola.domain.aluno.Aluno;
import br.com.augustogiacomini.escola.domain.aluno.AlunoNotFoundException;
import br.com.augustogiacomini.escola.domain.aluno.Cpf;
import br.com.augustogiacomini.escola.domain.aluno.Email;
import br.com.augustogiacomini.escola.domain.aluno.Telefone;
import br.com.augustogiacomini.escola.domain.aluno.AlunoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryJDBC implements AlunoRepository {

    private Connection connection;

    public AlunoRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getCpf().getNumero());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(1, aluno.getEmail());
            preparedStatement.execute();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                preparedStatement.setString(1, telefone.getDdd());
                preparedStatement.setString(2, telefone.getNumero());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getNumero());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new AlunoNotFoundException(cpf);
            }

            String nome = resultSet.getString("nome");
            Email email = new Email(resultSet.getString("email"));
            Aluno aluno = new Aluno(cpf, nome, email);

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String ddd = resultSet.getString("ddd");
                aluno.adicionarTelefone(ddd, numero);
            }

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = new ArrayList<>();

            while (resultSet.next()) {
                Cpf cpf = new Cpf(resultSet.getString("cpf"));
                String nome = resultSet.getString("nome");
                Email email = new Email(resultSet.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = resultSet.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String numero = resultSet.getString("numero");
                    String ddd = resultSet.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
                }

                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

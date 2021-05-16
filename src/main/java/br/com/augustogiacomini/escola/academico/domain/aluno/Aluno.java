package br.com.augustogiacomini.escola.domain.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private Cpf cpf;

    private String nome;

    private Email email;

    private List<Telefone> telefones = new ArrayList<>();

    private String senha;

    public Aluno(Cpf cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (this.telefones.size() == 2) {
            throw new AlunoMaxPhonesException(2);
        }

        this.telefones.add(new Telefone(ddd, numero));
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
}

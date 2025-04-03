package Negocio.Basicas;

import java.io.Serial;
import java.io.Serializable;

public abstract class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = -3952127239255731782L;
    private String nome;
    private String cpf;
    private int idade;
    private String sexo;
    private double avaliacao;
    private String senha;



    public Pessoa(String nome, String cpf, int idade, String sexo, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.avaliacao = 0;
        this.senha = senha;
    }

    public String getNome() { return nome; }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}

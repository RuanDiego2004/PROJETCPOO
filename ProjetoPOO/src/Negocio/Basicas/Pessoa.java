package Negocio.Basicas;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private String nome;
    private String cpf;
    private int idade;
    private String sexo;
    private double avaliacao;



    public Pessoa(String nome, String cpf, int idade, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.avaliacao = 0;
    }

    public String getNome() { return nome; }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", avaliacao=" + avaliacao +
                '}';
    }
}

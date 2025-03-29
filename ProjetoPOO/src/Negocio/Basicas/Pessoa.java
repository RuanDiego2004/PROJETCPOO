package Negocio.Basicas;

public abstract class Pessoa {
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
}

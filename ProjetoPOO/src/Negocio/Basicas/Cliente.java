package Negocio.Basicas;

public class Cliente extends Pessoa{
    private Cartao credito;


    public Cliente(String nome, String cpf, int idade, String sexo) {
        super(nome, cpf, idade, sexo);
    }
}

package Negocio.Basicas;

import java.io.Serial;

public class Cliente extends Pessoa {
    @Serial
    private static final long serialVersionUID = 2009502615378334785L;
    private Cartao credito;
    //


    public Cliente(String nome, String cpf, int idade, String sexo, String senha) {
        super(nome, cpf, idade, sexo, senha);
    }
}

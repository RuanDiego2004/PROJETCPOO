package Negocio.Basicas;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    @Serial
    private static final long serialVersionUID = 2009502615378334785L;
    public List<Cartao> cartoes;
    //


    public Cliente(String nome, String cpf, int idade, String sexo, String senha) {
        super(nome, cpf, idade, sexo, senha);
        cartoes = new ArrayList<Cartao>();

    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void ListarNumCartoes() {
        for(Cartao c : cartoes){
            System.out.println(c.numero);
            System.out.println(c.getLimitediposnivel());
        }
    }

}

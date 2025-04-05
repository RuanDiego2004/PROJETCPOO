package Negocio.Basicas;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    @Serial
    private static final long serialVersionUID = 2009502615378334785L;
    public List<FormaDePagamento> formasDePagamento;
    //


    public Cliente(String nome, String cpf, int idade, String sexo, String senha) {
        super(nome, cpf, idade, sexo, senha);
        formasDePagamento = new ArrayList<FormaDePagamento>();
        formasDePagamento.add(new FormaDePagamento("Dinheiro"));
        formasDePagamento.add(new FormaDePagamento("Pix"));
    }

    public List<FormaDePagamento> getFormasDePagamento() {
        return formasDePagamento;
    }

}

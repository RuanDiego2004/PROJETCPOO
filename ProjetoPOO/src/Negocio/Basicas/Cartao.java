package Negocio.Basicas;

import java.io.Serializable;

public class Cartao extends FormaDePagamento{
    private String numero;
    private int senha;
    private double limite;
    private double limitediposnivel;

    public Cartao(String numero, int senha, double limite,String tipo) {
        super("Cartão de Credito");
        this.numero = numero;
        this.senha = senha;
        this.limite = limite;
        this.limitediposnivel = limite;
    }

    public double getLimite() {
        return limite;
    }


}

package Negocio.Basicas;

import java.io.Serializable;

public class Cartao extends FormaDePagamento{
    public int numero;
    private int senha;
    private double limite;
    private double limitediposnivel;

    public Cartao(int numero, int senha, double limite) {
        super("Cartão de Credito");
        this.numero = numero;
        this.senha = senha;
        this.limite = limite;
        this.limitediposnivel = limite;
    }

    public double getLimite() {
        return limite;
    }

    public int getNumero() {
        return numero;
    }

    public int getSenha() {
        return senha;
    }

    public double getLimitediposnivel() {
        return limitediposnivel;
    }

    public void setLimitediposnivel(double limitediposnivel) {
        this.limitediposnivel = limitediposnivel;
    }
}

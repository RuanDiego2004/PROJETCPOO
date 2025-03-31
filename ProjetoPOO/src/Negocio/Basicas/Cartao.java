package Negocio.Basicas;

import java.io.Serializable;

public class Cartao {
    private String numero;
    private String senha;
    private double limite;
    private double limitediposnivel;

    public Cartao(String numero, String senha, double limite) {
        this.numero = numero;
        this.senha = senha;
        this.limite = limite;
        this.limitediposnivel = limite;
    }

    public double getLimite() {
        return limite;
    }

    public double getLimitediposnivel() {
        return limitediposnivel;
    }
}

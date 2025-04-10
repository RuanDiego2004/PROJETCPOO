package Negocio.Basicas;

import java.io.Serializable;

public class FormaDePagamento implements Serializable {
    private String tipo;

    public FormaDePagamento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


}

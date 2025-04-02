package Negocio.Basicas;

import java.io.Serial;
import java.io.Serializable;

public class Veiculo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1045289863215245800L;
    private String placa;
    private TipoVeiculo tipo;
    private String cor;
    private String modelo;

    public Veiculo(String placa, TipoVeiculo tipo, String cor, String modelo) {
        this.placa = placa;
        this.tipo = tipo;
        this.cor = cor;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", tipo=" + tipo +
                ", cor='" + cor + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

}

package Negocio.Basicas;

import java.io.Serializable;

public class Viagem implements Serializable {
    private Cidade cidade;
    private String destino;
    private String data;
    private String hora;
    private String origem;
    private Motorista motorista;
    private Cliente cliente;
    private double distancia;


    public Viagem(String destino, String data, String hora, String origem, Motorista motorista, Cliente cliente, double distancia, Cidade cidade) {
        this.destino = destino;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.motorista = motorista;
        this.cliente = cliente;
        this.distancia = distancia;
        this.cidade = cidade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "destino='" + destino + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", origem='" + origem + '\'' +
                ", motorista=" + motorista +
                ", cliente=" + cliente +
                ", distancia='" + distancia + '\'' +
                ", Veiculo ='" + motorista.getVeiculo().toString() + '\'' +
                '}';
    }
}

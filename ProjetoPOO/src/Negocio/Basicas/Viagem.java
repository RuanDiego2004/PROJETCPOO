package Negocio.Basicas;

public class Viagem {
    private String destino;
    private String data;
    private String hora;
    private String origem;
    private Motorista motorista;
    private Cliente cliente;
    private double distancia;


    public Viagem(String destino, String data, String hora, String origem, Motorista motorista, Cliente cliente, double distancia) {
        this.destino = destino;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.motorista = motorista;
        this.cliente = cliente;
        this.distancia = distancia;
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

package Negocio.Basicas;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Viagem implements Serializable {
    @Serial
    private static final long serialVersionUID = -4552933681783633117L;
    private Cidade cidade;
    private Local partida;
    private Local chegada;
    private LocalDateTime dataCorrida;
    private Motorista motorista;
    private Cliente cliente;
    private TipoDeViagem tipoDeViagem;
    private FormaDePagamento formaDePagamento;
    private int distancia;
    private double valor;

    public Viagem(Cidade cidade, Local partida, Local chegada, Motorista motorista, Cliente cliente, TipoDeViagem tipoDeViagem,FormaDePagamento formaDePagamento) {
        this.cidade = cidade;
        this.partida = partida;
        this.chegada = chegada;
        this.dataCorrida = LocalDateTime.now();
        this.motorista = motorista;
        this.cliente = cliente;
        this.tipoDeViagem = tipoDeViagem;
        this.distancia = (int) (Math.random() * (3000 - 50 + 1)) + 50; // essa coisa feia ai é de 50m até 3000m.
        this.valor = 5 + (0.40 + Math.random() * (2.00 - 0.40)) * (this.distancia / 1000.0); // minimo de 5 reais + algum valor de 0.4 a 2 reais por km
        this.formaDePagamento = formaDePagamento;
    }

    public Cidade getCidade() {
        return cidade;
    }


    @Override
    public String toString() {
        return "Viagem{" +
                "cidade=" + cidade +
                ", partida=" + partida +
                ", chegada=" + chegada +
                ", dataCorrida=" + dataCorrida +
                ", motorista=" + motorista +
                ", cliente=" + cliente +
                ", tipoDeViagem=" + tipoDeViagem +
                ", distancia=" + distancia +
                ", valor=" + valor +
                '}';
    }
}

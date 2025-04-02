package Negocio.Basicas;


import java.io.Serial;

public class Motorista extends Pessoa {

    @Serial
    private static final long serialVersionUID = 8894725064842758606L;
    private String cnh;
    private Veiculo veiculo;
//Renato testando

    public Motorista(String nome, String cpf, int idade, String sexo, String cnh, Veiculo veiculo) {
        super(nome, cpf, idade, sexo);
        this.cnh = cnh;
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public String getCnh() { return cnh; }

    @Override
    public String toString() {

        return "Motorista{"+
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", idade=" + getIdade() +
                ", sexo='" + getSexo() + '\'' +
                ", avaliacao=" + getAvaliacao() +
                ", cnh='" + cnh + '\'' +
                ", veiculo=" + veiculo +
                '}';
    }
}

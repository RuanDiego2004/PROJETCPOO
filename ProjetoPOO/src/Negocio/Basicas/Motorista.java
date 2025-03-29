package Negocio.Basicas;



public class Motorista extends Pessoa{
    private String cnh;
    private Veiculo veiculo;


    public Motorista(String nome, String cpf, int idade, String sexo, String cnh, Veiculo veiculo) {
        super(nome, cpf, idade, sexo);
        this.cnh = cnh;
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}

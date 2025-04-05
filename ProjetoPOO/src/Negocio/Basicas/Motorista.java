package Negocio.Basicas;


import java.io.Serial;

public class Motorista extends Pessoa {

    @Serial
    private static final long serialVersionUID = 8894725064842758606L;
    private String cnh;
    private Veiculo veiculo;
    private TipoDisponibilidade disponibilidade;
//Renato testando

    public Motorista(String nome, String cpf, int idade, String sexo, String cnh, Veiculo veiculo, String senha) {
        super(nome, cpf, idade, sexo, senha);
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.disponibilidade = TipoDisponibilidade.DISPONIVEL;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }


    public String getCnh() { return cnh; }

    public TipoDisponibilidade getDisponibiliade() { return disponibilidade;}

    @Override
    public String toString() {

        return String.format(
                "Nome: %s%n" +
                "Idade: %d%n" +
                "Sexo: %s%n" +
                "Avaliacao: %.2f%n" +
                "Veiculo: " + veiculo + "%n", getNome(),getIdade(),getSexo(),getAvaliacao()

        );
    }
}

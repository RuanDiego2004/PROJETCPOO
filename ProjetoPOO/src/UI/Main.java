package UI;

import Negocio.Basicas.*;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("2324", TipoVeiculo.SUV, "Preto", "opala");
        Motorista motorista = new Motorista("ruan","122323", 12, "Masculino", "123141324", veiculo);
        Cliente cliente = new Cliente("Renato", "1215453", 3, "Feminino");
        Cidade cidade = new Cidade();
        Viagem viagem = new Viagem("casa de carai", "ontem", "5 pra daq a pouco", "Ufape", motorista, cliente,11111,cidade);

        System.out.println(viagem);
    }
}

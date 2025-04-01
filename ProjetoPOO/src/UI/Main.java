package UI;

import Negocio.Basicas.*;
import Negocio.Fachada;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("2324", TipoVeiculo.SUV, "Preto", "opala");
        Motorista motorista = new Motorista("ruan","122323", 12, "Masculino", "123141324", veiculo);
        Cliente cliente = new Cliente("Renato", "1215453", 3, "Feminino");
        Cidade cidade = new Cidade("Iati");
        Viagem viagem = new Viagem("casa de carai", "ontem", "5 pra daq a pouco", "Ufape", motorista, cliente,11111,cidade);

        Fachada fachada = new Fachada();

        fachada.adicionarViagem(viagem);
        for(Viagem v : fachada.listarViagem()) {
            System.out.println(v.toString());
        }
        Cidade cidade02 = new Cidade("Iati");
        System.out.println("For \n------------");
        for(Viagem v : fachada.listarPorCidade(cidade02)){

            System.out.println(v.toString());
        }
        fachada.adicionarCidade(cidade02);
        System.out.println("-----------");
        System.out.println(fachada.buscarCidadePorNome("Iati").toString());

        }
    }


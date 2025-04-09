package Negocio;

import Dados.IRepositorioViagem;
import Dados.RepositorioViagemArquivo;
import Negocio.Basicas.*;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorViagem {
    IRepositorioViagem repositorio;

    GerenciadorViagem(){
        repositorio = new RepositorioViagemArquivo();
    }

    public void adicionarViagem(Viagem viagem){
        repositorio.adicionar(viagem);
    }

    //lista TODAS as viagens,tem q fazer tratamento ou não
    public List<Viagem> listar(){
        return repositorio.listarViagens();
    }



    public List<Viagem> buscarPorCidade(Cidade cidade) {
        return repositorio.buscarPorCidade(cidade);
    }

    public List<Viagem> buscarPorCliente(Cliente cliente) { return repositorio.buscarPorCliente(cliente); }

    public List<Viagem> buscarPorMotorista(Motorista motorista) { return repositorio.buscarPorMotorista(motorista); }



}

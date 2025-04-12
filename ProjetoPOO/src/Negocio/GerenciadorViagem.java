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

    public List<Viagem> listarViagensPorCliente(Cliente cliente){
        List<Viagem> viagens= new ArrayList<Viagem>();
        for(Viagem viagem: repositorio.listarViagens()){
            if(viagem.getCliente().getCpf().equals(cliente.getCpf())){
                viagens.add(viagem);
            }
        }
        return viagens;
    }

    public List<Viagem> listarViagensPorMotorista(Motorista motorista){
        List<Viagem> viagens= new ArrayList<Viagem>();
        for(Viagem viagem: repositorio.listarViagens()){
            if(viagem.getMotorista().getCnh().equals(motorista.getCnh())){
                viagens.add(viagem);
            }
        }
        return viagens;
    }

    public List<Viagem> buscarPorCidade(Cidade cidade) {
        return repositorio.buscarPorCidade(cidade);
    }




}

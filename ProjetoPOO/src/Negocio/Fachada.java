package Negocio;

import Negocio.Basicas.Cidade;
import Negocio.Basicas.Viagem;

import java.util.List;

public class Fachada {
    GerenciadorCidades gerenciadorCidades = new GerenciadorCidades();
    GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    GerenciadorMotorista gerenciadorMotorista = new GerenciadorMotorista();
    GerenciadorViagem gerenciadorViagem = new GerenciadorViagem();

    public List<Viagem> listarViagem(){
        return gerenciadorViagem.listar();
    }

    public List<Viagem> listarPorCidade(Cidade cidade){
        return gerenciadorViagem.buscarPorCidade(cidade);
    }

    public void adicionarViagem(Viagem viagem){
        gerenciadorViagem.adicionarViagem(viagem);
    }





}

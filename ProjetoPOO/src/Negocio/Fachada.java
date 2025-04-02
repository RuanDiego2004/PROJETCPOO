package Negocio;

import Dados.IRepositorioCidades;
import Negocio.Basicas.*;

import java.util.List;

public class Fachada {
    GerenciadorCidades gerenciadorCidades ;
    GerenciadorCliente gerenciadorCliente ;
    GerenciadorMotorista gerenciadorMotorista ;
    GerenciadorViagem gerenciadorViagem ;

    // inicio viagem

    public Fachada() {
        gerenciadorCidades = new GerenciadorCidades();
         gerenciadorCliente = new GerenciadorCliente();
         gerenciadorMotorista = new GerenciadorMotorista();
         gerenciadorViagem = new GerenciadorViagem();
    }
    public void adicionarViagem(Viagem viagem) {
        gerenciadorViagem.adicionarViagem(viagem);
    }

    public List<Viagem> listarViagem(){
        return gerenciadorViagem.listar();
    }

    public List<Viagem> listarPorCidade(Cidade cidade){
       return gerenciadorViagem.buscarPorCidade(cidade);
   }



    // fim viagem

    // inicio cidade

    public void adicionarCidade(Cidade cidade) throws EntidadeJaExisteException  {
        gerenciadorCidades.adicionarCidade(cidade);
    }

    public List<Cidade> listarCidade(){
        return gerenciadorCidades.ListarCidades();
    }

    public Cidade buscarCidadePorNome(String nome){
        return gerenciadorCidades.buscarCidadePorNome(nome);
    }


    // fim cidade

    //inicio cliente
    public void adicionarCliente(String nome, String cpf, int  idade , String sexo) {
        gerenciadorCliente.adicionarCliente(nome, cpf, idade, sexo);
    }

    public List<Cliente> listarCliente(){ return gerenciadorCliente.listarClientes(); }

    public Cliente buscarClientePorCpf(String Cpf){
        return gerenciadorCliente.buscarPorCpf(Cpf);
    }

    // fim cliente

    //inicio motorista

    public void adicionarMotorista(String nome, String cpf, int  idade , String sexo, String CNH, Veiculo veiculo) {
        gerenciadorMotorista.adicionarMotorista(nome, cpf, idade, sexo, CNH, veiculo);
    }

    public List<Motorista> listarMotorista(){ return gerenciadorMotorista.listarMotoristas(); }

    public Motorista buscarMotoristaPorCNH(String CNH){ return gerenciadorMotorista.buscarMotoristaPorCNH(CNH); }
}

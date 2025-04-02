package Negocio;

import Dados.IRepositorioCidades;
import Negocio.Basicas.Cidade;
import Negocio.Basicas.Cliente;
import Negocio.Basicas.Viagem;

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
        System.out.println("Teste");
        return gerenciadorCidades.buscarCidadePorNome(nome);
    }


    // fim cidade

    //inicio cliente
    public void adicionarCliente(String nome, String cpf, int  idade , String sexo) {
        gerenciadorCliente.adicionarCliente(nome, cpf, idade, sexo);
    }

    public List<Cliente> listarCliente(){ return gerenciadorCliente.ListarClientes(); }

    public Cliente buscarClientePorCpf(String Cpf){
        return gerenciadorCliente.buscarPorCpf(Cpf);
    }



}

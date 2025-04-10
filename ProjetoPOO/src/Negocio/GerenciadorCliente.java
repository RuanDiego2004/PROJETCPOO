package Negocio;

import Dados.IRepositorioCliente;
import Dados.RepositorioClienteArquivo;
import Negocio.Basicas.Cartao;
import Negocio.Basicas.Cliente;

import java.util.List;

public class GerenciadorCliente {
    IRepositorioCliente repositorio;

    public GerenciadorCliente() { repositorio = new RepositorioClienteArquivo();  }

    public void adicionarCliente(String nome, String cpf, int  idade , String sexo, String senha) throws CPFJaUtilizadoException {
        if(repositorio.buscarPorCpf(cpf) != null){
            throw new CPFJaUtilizadoException();
        }
        Cliente cliente = new Cliente(nome, cpf, idade, sexo, senha);
        repositorio.adicionar(cliente);
    }
    public void avaliarViagem(double m,Cliente cliente) {  repositorio.avaliarViagem(m,cliente); }

    public Cliente buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }
    public List<Cliente> listarClientes () {
        return repositorio.listarClientes();
    }

    // Forma de pagamento

    public void adicionarCartao(Cliente cliente,int numeroCartao,int senhaCartao,double limite) throws CartaoJaCadastradoException {
        for(Cartao cartao : cliente.getCartoes()){
            if(cartao.numero == numeroCartao){
                throw new CartaoJaCadastradoException();
            }
        }
        repositorio.adicionarCartao(new Cartao(numeroCartao,senhaCartao,limite),cliente);
    }

    public void validarPagamento(Cartao cartao,double valor) throws LimiteInsuficienteException{
        if(cartao.getLimitediposnivel()< valor){
            throw new LimiteInsuficienteException();
        }
    }

    public void validarFormaDePagamento(String tipo) throws FormaDePagamentoInvalidoException {
        if(tipo.equalsIgnoreCase("Dinheiro") || tipo.equalsIgnoreCase("Pix") ||  tipo.equalsIgnoreCase("Cartao")){
            return;
        }else { throw new FormaDePagamentoInvalidoException(); }
    }

    public Cartao verificarNumCartao (Cliente cliente,int num) throws CartaoNaoEncontradoException{
        Cartao cartao = null;
        boolean achou = false;
        for(Cartao c : cliente.getCartoes()){
            if( c.numero == num){
                cartao = c;
                achou = true;
            }
        }
        if(achou == false){
            throw new CartaoNaoEncontradoException();
        }
        return cartao;
    }
}


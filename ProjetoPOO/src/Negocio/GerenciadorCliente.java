package Negocio;

import Dados.IRepositorioCliente;
import Dados.RepositorioClienteArquivo;
import Negocio.Basicas.Cartao;
import Negocio.Basicas.Cliente;
import Negocio.Basicas.FormaDePagamento;

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

    // talvez validar forma de pagamento seja aqui??
    public void validarPagamento(Cliente cliente,String forma) {

    }

    public void validarPagamento(Cliente cliente,String forma,String numero,double valor) throws Exception{
        Cartao cartao= null;
        for(FormaDePagamento fdp : cliente.getFormasDePagamento()){
            //teste se for Cartão
            if(fdp.getTipo().equals(forma)){
                //Teste se tem numero
                cartao= (Cartao) fdp;
                if(cartao.getNumero().equals(numero)){
                    // Teste se tem limite
                    if(cartao.getLimitediposnivel() >= valor){
                        //tem limite
                        cartao.setLimitediposnivel(cartao.getLimitediposnivel() - valor); //descontando limite
                    }
                }
            }
        }

    }
    // oq ele retornaria se nao encontrasse cartão?
}


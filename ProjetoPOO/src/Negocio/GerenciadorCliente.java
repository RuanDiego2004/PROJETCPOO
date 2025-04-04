package Negocio;

import Dados.IRepositorioCliente;
import Dados.RepositorioClienteArquivo;
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
    public Cliente buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }
    public List<Cliente> listarClientes () {
        return repositorio.listarClientes();
    }

    // talvez validar forma de pagamento seja aqui??

}

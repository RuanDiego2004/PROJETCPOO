package Negocio;

import Dados.IRepositorioCliente;
import Dados.RepositorioClienteArquivo;
import Negocio.Basicas.Cidade;
import Negocio.Basicas.Cliente;

import java.util.List;

public class GerenciadorCliente {
    IRepositorioCliente repositorio;

    public GerenciadorCliente() { repositorio = new RepositorioClienteArquivo();  }

    public void adicionarCliente(String nome, String cpf, int  idade , String sexo) throws EntidadeJaExisteException {
        if(repositorio.buscarPorCpf(cpf) != null){
            throw new EntidadeJaExisteException("Já existe uma cidade com este nome.");
        }else {
            Cliente cliente = new Cliente(nome, cpf, idade, sexo);
            repositorio.adicionar(cliente);
        }
    }
    public Cliente buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }
    public List<Cliente> ListarClientes () {
        return repositorio.listarClientes();
    }


}

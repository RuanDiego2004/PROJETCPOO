package Dados;

import Negocio.Basicas.Cliente;

import java.util.List;

public class RepositorioClienteArquivo implements IRepositorioCliente {

    @Override
    public void adicionar(Cliente cliente) {

    }

    @Override
    public Cliente buscarPorCpf(String nome) {
        return null;
    }

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }
}

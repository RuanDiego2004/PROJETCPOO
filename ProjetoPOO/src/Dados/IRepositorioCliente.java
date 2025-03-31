package Dados;

import Negocio.Basicas.*;
import java.util.List;

public interface IRepositorioCliente {
    void adicionar(Cliente cliente);
    Cliente buscarPorCpf(String nome);
    List<Cliente> listarClientes();

}

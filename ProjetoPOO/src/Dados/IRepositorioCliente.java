package Dados;

import Negocio.Basicas.*;
import java.util.List;

public interface IRepositorioCliente {
    void adicionar(Cliente cliente);
    Cliente buscarPorCpf(String cpf);
    List<Cliente> listarClientes();
    void avaliarViagem(double m,Cliente cliente);
    void adicionarCartao(Cartao cartao, Cliente cliente);
}

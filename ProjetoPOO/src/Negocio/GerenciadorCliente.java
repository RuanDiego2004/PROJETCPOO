package Negocio;

import Dados.IRepositorioCliente;
import Dados.RepositorioClienteArquivo;

public class GerenciadorCliente {
    IRepositorioCliente repositorio = new RepositorioClienteArquivo();
}

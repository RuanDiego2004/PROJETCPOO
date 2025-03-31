package Negocio;

import Dados.IRepositorioMotorista;
import Dados.RepositorioMotoristaArquivo;

public class GerenciadorMotorista {
    IRepositorioMotorista repositorio = new RepositorioMotoristaArquivo();
}

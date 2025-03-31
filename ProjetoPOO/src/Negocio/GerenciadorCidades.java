package Negocio;

import Dados.IRepositorioCidades;
import Dados.RepositorioCidadesArquivo;

public class GerenciadorCidades {
    IRepositorioCidades repositorio = new RepositorioCidadesArquivo();
}

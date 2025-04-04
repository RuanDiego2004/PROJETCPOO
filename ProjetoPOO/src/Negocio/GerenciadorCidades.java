package Negocio;

import Dados.IRepositorioCidades;
import Dados.RepositorioCidadesArquivo;
import Negocio.Basicas.Cidade;

import java.util.List;

public class GerenciadorCidades {
    IRepositorioCidades repositorio;

    GerenciadorCidades(){
        repositorio = new RepositorioCidadesArquivo();
    }

    public void adicionarCidade(Cidade cidade) throws CidadeJaExisteException {
        if(repositorio.buscarPorNome(cidade.nome) != null) {
            throw new CidadeJaExisteException();
        }
        repositorio.adicionar(cidade);
    }

    public List<Cidade> ListarCidades() {
        return repositorio.listarCidades();
    }

    public Cidade buscarCidadePorNome(String nome){
        return repositorio.buscarPorNome(nome);
    }

}

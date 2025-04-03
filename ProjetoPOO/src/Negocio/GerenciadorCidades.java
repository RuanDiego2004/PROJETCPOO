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

    public void adicionarCidade(Cidade cidade) throws EntidadeNaoExisteException {
        if(repositorio.buscarPorNome(cidade.nome) != null) {
            throw new EntidadeNaoExisteException("Já existe uma cidade com este nome.");
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

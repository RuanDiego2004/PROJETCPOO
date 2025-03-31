package Dados;

import Negocio.Basicas.Cidade;

import java.util.List;

public class RepositorioCidadesArquivo implements IRepositorioCidades {
    String arquivo = "ArquivoCidade.ser";
    List<Cidade> cidades;

    @Override
    public void adicionar(Cidade cidade) {

    }

    @Override
    public Cidade buscarPorNome(String cidade) {
        return null;
    }

    @Override
    public List<Cidade> listarCidades() {
        return List.of();
    }

    private void salvar(){

    }
}

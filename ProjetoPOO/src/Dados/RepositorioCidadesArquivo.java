package Dados;

import Negocio.Basicas.Cidade;

import java.util.List;

public class RepositorioCidadesArquivo implements IRepositorioCidades {

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
}

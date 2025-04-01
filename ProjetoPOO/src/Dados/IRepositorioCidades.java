package Dados;

import Negocio.Basicas.Cidade;

import java.util.List;

public interface IRepositorioCidades {
    void adicionar(Cidade cidade);
    public Cidade buscarPorNome(String cidade);
    public List<Cidade> listarCidades();
}

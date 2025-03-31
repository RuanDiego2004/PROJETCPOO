package Dados;

import Negocio.Basicas.Cidade;

import java.util.List;

public interface IRepositorioCidades {
    void adicionar(Cidade cidade);
    Cidade buscarPorNome(String cidade);
    List<Cidade> listarCidades();
}

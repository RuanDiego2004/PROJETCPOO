package Dados;

import Negocio.Basicas.Viagem;

import java.util.List;

public class RepositorioViagemArquivo implements IRepositorioViagem{

    @Override
    public Viagem buscarPorNome(String cidade) {
        return null;
    }

    @Override
    public List<Viagem> listarViagens() {
        return List.of();
    }
}

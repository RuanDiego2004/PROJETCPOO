package Negocio;

import Dados.IRepositorioViagem;
import Dados.RepositorioViagemArquivo;
import Negocio.Basicas.Cidade;
import Negocio.Basicas.Viagem;

import java.util.List;

public class GerenciadorViagem {
    IRepositorioViagem repositorio = new RepositorioViagemArquivo();

    //lista TODAS as viagens,
    public List<Viagem> listar(){
        return repositorio.listarViagens();
    }

    public List<Viagem> buscarPorCidade(Cidade cidade) {
            return repositorio.buscarPorCidade(cidade);
    }

}

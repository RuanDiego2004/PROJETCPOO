package Dados;

import Negocio.Basicas.Cidade;
import Negocio.Basicas.Viagem;
import java.util.List;

public interface IRepositorioViagem {
     public void adicionar(Viagem cidade);
    List<Viagem> buscarPorCidade(Cidade cidade);
    List<Viagem> listarViagens();
}

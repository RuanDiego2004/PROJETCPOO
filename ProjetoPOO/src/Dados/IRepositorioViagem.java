package Dados;

import Negocio.Basicas.Viagem;
import java.util.List;

public interface IRepositorioViagem {
    static void adicionar(Viagem cidade) {
        // estou pensando em fazer um metodo estatico de adicionar viagem, pq, onde precisar, só chamar
        // o metodo IRepositorioViagem, passar os parametros que o metodo implementado vai adicionar no arquivo
        // mas é só uma ideia, não sei a melhor forma de fazer isso.
    }

    Viagem buscarPorNome(String cidade);
    List<Viagem> listarViagens();
}

package Dados;

import java.util.List;
import Negocio.Basicas.*;

public interface IRepositorioMotorista {
    void adicionar(Motorista motorista);
    Motorista buscarPorCPF(String numero);
    List<Motorista> listar();
}

package Dados;

import java.util.List;
import Negocio.Basicas.*;

public interface IRepositorioMotorista {
    void adicionar(Motorista motorista);
    Motorista buscarPorCPF(String CPF);
    Motorista buscarPorCNH(String CNH);
    List<Motorista> listarMotoristas();
}

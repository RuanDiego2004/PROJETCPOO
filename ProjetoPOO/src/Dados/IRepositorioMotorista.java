package Dados;

import java.util.List;
import Negocio.Basicas.*;

public interface IRepositorioMotorista {
    void adicionar(Motorista motorista);
    Motorista buscarPorCNH(String CNH);
    List<Motorista> listarMotoristas();
    Motorista buscarPorCPF(String cpf);
    void avaliarViagem(double a,Motorista motorista);
}

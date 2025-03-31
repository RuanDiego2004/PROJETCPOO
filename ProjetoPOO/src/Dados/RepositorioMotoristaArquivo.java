package Dados;

import Negocio.Basicas.Motorista;

import java.util.List;

public class RepositorioMotoristaArquivo implements IRepositorioMotorista{
    String arquivo = "ArquivoMotorista.ser";
    List<Motorista> motoristas;

    @Override
    public void adicionar(Motorista motorista) {

    }

    @Override
    public Motorista buscarPorCPF(String CPF) {
        return null;
    }

    @Override
    public Motorista buscarPorCNH(String CNH) {
        return null;
    }

    @Override
    public List<Motorista> listarMotoristas() {
        return List.of();
    }
}

package Negocio;

import Dados.IRepositorioMotorista;
import Dados.RepositorioMotoristaArquivo;
import Negocio.Basicas.Motorista;
import Negocio.Basicas.Veiculo;

import java.util.List;

public class GerenciadorMotorista {
    IRepositorioMotorista repositorio;

    public GerenciadorMotorista() { repositorio = new RepositorioMotoristaArquivo(); }

    public void adicionarMotorista(String nome, String cpf, int  idade , String sexo,String CNH, Veiculo veiculo, String senha) throws EntidadeJaExisteException {
        if(repositorio.buscarPorCNH(CNH) != null){
            throw new EntidadeJaExisteException();
        }
        Motorista motorista = new Motorista(nome, cpf, idade, sexo , CNH, veiculo, senha);
        repositorio.adicionar(motorista);
    }

    public Motorista buscarMotoristaPorCNH(String CNH)  {
        return repositorio.buscarPorCNH(CNH);
    }

    public List<Motorista> listarMotoristas()  {
      return repositorio.listarMotoristas();
    }

}

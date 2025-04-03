package Negocio;

import Dados.IRepositorioCidades;
import Negocio.Basicas.*;

import java.util.List;

public class Fachada {
    GerenciadorCidades gerenciadorCidades ;
    GerenciadorCliente gerenciadorCliente ;
    GerenciadorMotorista gerenciadorMotorista ;
    GerenciadorViagem gerenciadorViagem ;

    // inicio viagem

    public Fachada() {
        gerenciadorCidades = new GerenciadorCidades();
         gerenciadorCliente = new GerenciadorCliente();
         gerenciadorMotorista = new GerenciadorMotorista();
         gerenciadorViagem = new GerenciadorViagem();
    }
    public void adicionarViagem(Viagem viagem) {
        gerenciadorViagem.adicionarViagem(viagem);
    }

    public List<Viagem> listarViagem(){
        return gerenciadorViagem.listar();
    }

    public List<Viagem> listarPorCidade(Cidade cidade){
       return gerenciadorViagem.buscarPorCidade(cidade);
   }



    // fim viagem

    // inicio cidade

    public void adicionarCidade(Cidade cidade) throws EntidadeJaExisteException  {
        gerenciadorCidades.adicionarCidade(cidade);
    }

    public List<Cidade> listarCidade(){
        return gerenciadorCidades.ListarCidades();
    }

    public Cidade buscarCidadePorNome(String nome){
        return gerenciadorCidades.buscarCidadePorNome(nome);
    }


    // fim cidade

    //inicio cliente
    public void adicionarCliente(String nome, String cpf, int  idade , String sexo, String senha) {
        gerenciadorCliente.adicionarCliente(nome, cpf, idade, sexo, senha);
    }

    public List<Cliente> listarCliente(){ return gerenciadorCliente.listarClientes(); }

    public Cliente buscarClientePorCpf(String Cpf){
        return gerenciadorCliente.buscarPorCpf(Cpf);
    }

    // fim cliente

    //inicio motorista

    public void adicionarMotorista(String nome, String cpf, int  idade , String sexo, String CNH, Veiculo veiculo , String senha) {
        gerenciadorMotorista.adicionarMotorista(nome, cpf, idade, sexo, CNH, veiculo, senha);
    }

    public List<Motorista> listarMotorista(){ return gerenciadorMotorista.listarMotoristas(); }

    public Motorista buscarMotoristaPorCNH(String CNH){ return gerenciadorMotorista.buscarMotoristaPorCNH(CNH); }

    //inicio Autenticadores
    public Cliente autenticarCliente(String cpf, String senha) {
        Cliente c = buscarClientePorCpf(cpf);
        if (c == null && senha != c.getSenha()) {
            return null;
        }
        return c;
    }
    public Motorista autenticarMotorista(String cnh, String senha) {
        Motorista m = buscarMotoristaPorCNH(cnh);
        if (m == null && senha != m.getSenha()) {
            return null;
        }
        return m;
    }
    //fim Autenticadores

    //
    public Motorista buscarMotoristaDisponivel( TipoVeiculo tipoVeiculo) {
        List<Motorista> m = listarMotorista();
        for (Motorista motorista : m) {
            if(motorista.getVeiculo().getTipo().equals(tipoVeiculo) && motorista.getDisponibiliade().equals(TipoDisponibilidade.DISPONIVEL)) {
                return motorista;
            }
        }
        return null;
    }




}

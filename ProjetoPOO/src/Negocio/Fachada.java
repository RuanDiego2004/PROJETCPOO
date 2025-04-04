package Negocio;

import Negocio.Basicas.*;

import java.util.List;
import java.util.Objects;

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

    public void adicionarCidade(Cidade cidade) throws EntidadeNaoExisteException  {
        try {
            gerenciadorCidades.adicionarCidade(cidade);
        }catch (EntidadeNaoExisteException e) {
            e.printStackTrace();
        }
    }

//    public String validarPagamento(String tipoPagamento) throws LimiteInsuficienteException {}

    public List<Cidade> listarCidade(){
        return gerenciadorCidades.ListarCidades();
    }

    public Cidade buscarCidadePorNome(String nome){
        return gerenciadorCidades.buscarCidadePorNome(nome);
    }


    // fim cidade

    //inicio cliente
    public void adicionarCliente(String nome, String cpf, int  idade , String sexo, String senha) throws EntidadeJaExisteException{
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
    public Cliente autenticarCliente(String cpf, String senha) throws EntidadeNaoExisteException {
        Cliente c = buscarClientePorCpf(cpf);
        if (c == null || !senha.equals(c.getSenha())) {
            throw new EntidadeNaoExisteException("CPF ou senha estão incorretos");
        }
        return c;
    }

    public Motorista autenticarMotorista(String cnh, String senha) {
        Motorista m = buscarMotoristaPorCNH(cnh);
        if (m == null || !senha.equals(m.getSenha())) {
            throw new EntidadeNaoExisteException("CNH ou senha estão incorretos");
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
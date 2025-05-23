package Negocio;

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

    public List<Viagem> listarViagensPorCliente(Cliente cliente){ return gerenciadorViagem.listarViagensPorCliente(cliente); }

    public List<Viagem> listarViagensPorMotorista(Motorista motorista){ return gerenciadorViagem.listarViagensPorMotorista(motorista);}

    // fim viagem

    // inicio cidade

    public void adicionarCidade(Cidade cidade) throws CidadeJaExisteException  {
            gerenciadorCidades.adicionarCidade(cidade);
    }

// forma de pagamento

    public void validarFormaDePagamento(String tipo) throws FormaDePagamentoInvalidoException {
        gerenciadorCliente.validarFormaDePagamento(tipo);
    }

    public void validarPagamento(Cartao cartao,double valor) throws LimiteInsuficienteException {
        gerenciadorCliente.validarPagamento(cartao,valor);
    }

    public Cartao verificarNumCartao (Cliente cliente,int num) throws CartaoNaoEncontradoException{
        return gerenciadorCliente.verificarNumCartao(cliente,num);
    }

// Fim forma de pagamento



    public List<Cidade> listarCidade(){
        return gerenciadorCidades.ListarCidades();
    }

    public Cidade buscarCidadePorNome(String nome){
        return gerenciadorCidades.buscarCidadePorNome(nome);
    }


    // fim cidade

    //inicio cliente
    public void adicionarCliente(String nome, String cpf, int  idade , String sexo, String senha) throws CPFJaUtilizadoException{
        gerenciadorCliente.adicionarCliente(nome, cpf, idade, sexo, senha);
    }

    public List<Cliente> listarCliente(){ return gerenciadorCliente.listarClientes(); }

    public Cliente buscarClientePorCpf(String Cpf){
        return gerenciadorCliente.buscarPorCpf(Cpf);
    }
    public void avaliarViagemCliente(double m,Cliente cliente) {  gerenciadorCliente.avaliarViagem(m,cliente); }

    public void adicionarCartão(Cliente cliente,int numeroCartao,int senhaCartao,double limite) throws CartaoJaCadastradoException{
        gerenciadorCliente.adicionarCartao(cliente,numeroCartao,senhaCartao,limite);
    }

    public void salvarCliente(){
        gerenciadorCliente.salvarCliente();
    }

    // fim cliente

    //inicio motorista

    public void adicionarMotorista(String nome, String cpf, int  idade , String sexo, String CNH, Veiculo veiculo , String senha) throws Exception {
        gerenciadorMotorista.adicionarMotorista(nome, cpf, idade, sexo, CNH, veiculo, senha);
    }

    public void avaliarViagemMotorista(double a,Motorista motorista) {  gerenciadorMotorista.avaliarViagem(a,motorista); }



    public List<Motorista> listarMotorista(){ return gerenciadorMotorista.listarMotoristas(); }

    public Motorista buscarMotoristaPorCNH(String CNH){ return gerenciadorMotorista.buscarMotoristaPorCNH(CNH); }

    //inicio Autenticadores
    public Cliente autenticarCliente(String cpf, String senha) throws LoginInvalidoException {
        Cliente c = buscarClientePorCpf(cpf);
        if (c == null || !senha.equals(c.getSenha())) {
            throw new LoginInvalidoException();
        }
        return c;
    }

    public Motorista autenticarMotorista(String cnh, String senha) throws LoginInvalidoException{
        Motorista m = buscarMotoristaPorCNH(cnh);
        if (m == null || !senha.equals(m.getSenha())) {
            throw new LoginInvalidoException();
        }
        return m;
    }
    public Boolean autenticarCPF(String cpf) {
         if (cpf.matches("\\d{11}")) {
           return true;
        } else {
             System.out.println();
             System.out.println("CPF inválido. Somente números e 11 digitos");
             System.out.println();
             return false;
        }
}
    //fim Autenticadores





}
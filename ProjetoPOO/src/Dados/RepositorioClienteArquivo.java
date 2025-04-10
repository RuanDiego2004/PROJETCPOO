package Dados;

import Negocio.Basicas.Cartao;
import Negocio.Basicas.Cliente;
import Negocio.CartaoJaCadastradoException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioClienteArquivo implements IRepositorioCliente {
    String arquivo = "ArquivoCliente.ser";
    List<Cliente> clientes;

    public RepositorioClienteArquivo() {
        clientes = carregar();
    }

    @Override
    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
        salvar();
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }



    @Override
    public List<Cliente> listarClientes() { return clientes; }

    private List<Cliente> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Cliente>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<Cliente>();
        }
    }

    private void salvar(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(clientes);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void avaliarViagem(double m,Cliente cliente) {
        for (Cliente c : clientes) {
            if (cliente.getCpf().equals(c.getCpf())) {
                double r = (c.getAvaliacao() + m )/ 2;
                c.setAvaliacao(r);
            }
        }
        salvar();
    }

    @Override
    public void adicionarCartao(Cartao cartao, Cliente cliente) {
        cliente.cartoes.add(cartao);
        salvar();
    }

}

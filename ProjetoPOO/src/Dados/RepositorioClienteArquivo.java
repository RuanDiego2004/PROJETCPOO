package Dados;

import Negocio.Basicas.Cliente;

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
}

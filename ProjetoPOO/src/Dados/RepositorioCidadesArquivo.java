package Dados;

import Negocio.Basicas.Cidade;
import Negocio.EntidadeJaExisteException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCidadesArquivo implements IRepositorioCidades {
    private String arquivo = "ArquivoCidade.ser";
    private List<Cidade> cidades;

    public RepositorioCidadesArquivo() {cidades = carregar();}

    @Override
    public void adicionar(Cidade cidade) throws EntidadeJaExisteException {
        cidades.add(cidade);
        salvar();
    }

    private void salvar(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(cidades);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private List<Cidade> carregar(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            return (List<Cidade>) ois.readObject();
        }catch (Exception e){
            return new ArrayList<Cidade>();
        }
    }

    @Override
    public Cidade buscarPorNome(String nomeCidade) {
        for(Cidade c : listarCidades()){
            if(c.nome.equalsIgnoreCase(nomeCidade)){
                return c;
            }
        }
        return null;
    }
    @Override
    public List<Cidade> listarCidades() {
        return cidades;
    }


}

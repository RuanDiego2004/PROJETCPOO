package Dados;

import Negocio.Basicas.Motorista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMotoristaArquivo implements IRepositorioMotorista{
    String arquivo = "ArquivoMotorista.ser";
    List<Motorista> motoristas;

    public RepositorioMotoristaArquivo(){
        motoristas = carregar();
    }

    @Override
    public void adicionar(Motorista motorista) {
        motoristas.add(motorista);
        salvar();
    }

    @Override
    public Motorista buscarPorCNH(String CNH) {
        for (Motorista motorista : motoristas) {
            if(motorista.getCnh().equals(CNH)){
                return motorista;
            }
        }
        return null;
    }

    @Override
    public List<Motorista> listarMotoristas() { return motoristas; }

    private void salvar(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(motoristas);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private List<Motorista> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Motorista>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<Motorista>();
        }
    }

}

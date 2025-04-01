package Dados;

import Negocio.Basicas.Cidade;
import Negocio.Basicas.Viagem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepositorioViagemArquivo implements IRepositorioViagem{
    String arquivo = "ArquivoViagem.ser";
    List<Viagem> viagens;

    public RepositorioViagemArquivo() { viagens = carregar(); }

    public void adicionar(Viagem viagem) {
        viagens.add(viagem);
        salvar();
    }

    public List<Viagem> buscarPorCidade(Cidade cidade) {
        List<Viagem> temp = new ArrayList<Viagem>();
        for (Viagem v : viagens) {
            if (v.getCidade().nome.equals(cidade.nome)) {
                temp.add(v);
            }
        }
        if(temp.isEmpty()){
            return null;
        }
        return temp;
    }

    private void salvar(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(viagens);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    private List<Viagem> carregar(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            return (List<Viagem>) ois.readObject();
        }catch(Exception e){
            return new ArrayList<Viagem>();
        }
    }





    @Override
    public List<Viagem> listarViagens() {
        return this.viagens;
    }

}

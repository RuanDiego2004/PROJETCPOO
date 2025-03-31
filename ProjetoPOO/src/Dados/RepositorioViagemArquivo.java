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

    RepositorioViagemArquivo() { viagens = carregar(); }

    @Override
    public List<Viagem> buscarPorCidade(Cidade cidade) {
        List<Viagem> temp = new ArrayList<Viagem>();
        for (Viagem v : viagens) {
            if (v.getCidade().equals(cidade)) {
                temp.add(v);
            }
        }
        if(temp.isEmpty()){
            return null;
        }
        return temp;
    }



    @Override
    public List<Viagem> listarViagens() {
        return this.viagens;
    }

    private List<Viagem> carregar(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
            return (List<Viagem>) ois.readObject();
        }catch(Exception e){
            return new ArrayList<>();
        }
    }

    public void adicionar(Viagem viagem) {
        viagens.add(viagem);
        salvar();
    }

    private void salvar(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oos.writeObject(viagens);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}

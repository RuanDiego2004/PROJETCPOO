package Dados;

import Negocio.Basicas.Cidade;
import Negocio.Basicas.Viagem;

import java.util.ArrayList;
import java.util.List;

public class RepositorioViagemArquivo implements IRepositorioViagem{
    String arquivo = "ArquivoViagem.ser";
    List<Viagem> viagens;

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

    public void adicionar(Viagem viagem) {
        this.viagens.add(viagem);
        salvar();
    }

    private void salvar(){

    }


}

package Negocio.Basicas;

public class CidadeJaExisteException extends RuntimeException {
    public CidadeJaExisteException(){

    }
    public String getMensagem(){
        return "Cidade ja existe";
    }



}

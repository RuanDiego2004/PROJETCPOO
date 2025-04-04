package Negocio;

public class CidadeJaExisteException extends RuntimeException {
    public CidadeJaExisteException(){
        super("Cidade ja existe");
    }




}

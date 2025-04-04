package Negocio;

public class CPFJaUtilizadoException extends RuntimeException {
    public CPFJaUtilizadoException() {
        super();
    }

    public String getMensagem(){
        return "Este CPF ja foi utilizado.";
    }
}

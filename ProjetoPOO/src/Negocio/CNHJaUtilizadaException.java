package Negocio;

public class CNHJaUtilizadaException extends RuntimeException {
    public CNHJaUtilizadaException() {
        super();
    }

    public String getMensagem(){
        return "Esta CNH ja foi utilizada.";
    }
}

package Negocio;

public class CNHJaUtilizadaException extends RuntimeException {
    public CNHJaUtilizadaException() {
        super("Esta CNH ja foi utilizada.");
    }
}

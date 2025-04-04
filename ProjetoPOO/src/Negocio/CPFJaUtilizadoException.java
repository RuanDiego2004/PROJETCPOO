package Negocio;

public class CPFJaUtilizadoException extends RuntimeException {
    public CPFJaUtilizadoException() {
        super("Este CPF ja foi utilizado.");
    }
}

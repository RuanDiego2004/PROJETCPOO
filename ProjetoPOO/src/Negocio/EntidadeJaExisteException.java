package Negocio;

public class EntidadeJaExisteException extends RuntimeException {
    public EntidadeJaExisteException() {
        super("Já existe um Cliente com este CPF.");
    }
}

package Negocio.Basicas;

public class LimiteInsuficienteException extends RuntimeException {
    public LimiteInsuficienteException(String message) {
        super("Erro: Limite insuficiente.");
    }
}

package Negocio;

public class LimiteInsuficienteException extends RuntimeException {
    public LimiteInsuficienteException() {
        super("Erro: cartão não tem limite o suficiente.");
    }
}

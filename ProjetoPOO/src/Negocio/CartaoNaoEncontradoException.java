package Negocio;

public class CartaoNaoEncontradoException extends RuntimeException {
    public CartaoNaoEncontradoException() {
        super("Cartao nao encontrado");
    }
}

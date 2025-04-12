package Negocio;

public class CartaoNaoEncontradoException extends RuntimeException {
    public CartaoNaoEncontradoException() {
        super("Cartão nao encontrado");
    }
}

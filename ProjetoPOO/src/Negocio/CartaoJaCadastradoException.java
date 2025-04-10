package Negocio;

public class CartaoJaCadastradoException extends Exception {
    public CartaoJaCadastradoException() {
        super("Cartão ja está cadastrado");
    }
}

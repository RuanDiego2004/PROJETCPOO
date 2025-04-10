package Negocio;

public class ClienteNaoTemCartaoException extends RuntimeException {
    public ClienteNaoTemCartaoException() {
        super("Cliente nao possui nenhum cartao cadastrado");
    }
}

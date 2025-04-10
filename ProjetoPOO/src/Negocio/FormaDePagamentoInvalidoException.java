package Negocio;

public class FormaDePagamentoInvalidoException extends RuntimeException {
    public FormaDePagamentoInvalidoException() {
        super("Tipo de pagamento invalido");
    }
}

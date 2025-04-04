package Negocio;

public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException() {

    }

  public String getMensagem(){
    return "Login Invalido.";
  }
}

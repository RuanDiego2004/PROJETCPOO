package Negocio.Basicas;

import java.io.Serial;
import java.io.Serializable;

public class Local implements Serializable {
    @Serial
    private static final long serialVersionUID = 9077123703945665149L;
    private String nome;
    private String endereco;

    public Local(String nome ,String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

}

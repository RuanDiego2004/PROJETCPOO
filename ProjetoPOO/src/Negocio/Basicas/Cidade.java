package Negocio.Basicas;

import java.io.Serializable;

public class Cidade implements Serializable {

        public String nome;


        public Cidade(String nome){
                this.nome = nome;
        }

        @Override
        public String toString() {
                return "Cidade{" +
                        "nome='" + nome + '\'' +
                        '}';
        }
}

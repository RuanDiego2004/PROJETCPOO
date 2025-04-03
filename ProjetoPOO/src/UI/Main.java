package UI;

import Dados.RepositorioMotoristaArquivo;
import Negocio.*;
import Negocio.Basicas.*;
import Negocio.Fachada;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fachada fachada = new Fachada();
        Cidade cidadeAtual = null;
        Cliente clienteAtivo = null;
        Motorista motoristaAtivo = null;

        // Declarações de Auxiliares
        String cpf;
        String senha;
        String cnh;
        int opcao;
        int opcaomenor;

        //loop para garantir que existe uma cidade.

    while(true){
        if(fachada.listarCidade().isEmpty()){
            System.out.println("Nenhuma cidade cadastrada.");
            System.out.println("Cadastre ao menos uma cidade para fazer uma corrida.");
            System.out.println("Digite o nome da cidade que deseja castrar:");
            String nome = scanner.nextLine();
            try{
                fachada.adicionarCidade(new Cidade(nome));
                System.out.println("Cidade cadastrada.");
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        break;
    }

    while(cidadeAtual == null){
        System.out.println("Cidades cadastradas no sistema:");
        for(Cidade c : fachada.listarCidade()){
            System.out.println("\033[47;30m"+c.nome+"\033[0m");
        }
        System.out.println("Digite o nome da cidade que deseja acessar:");
        String nome = scanner.nextLine();
        cidadeAtual = fachada.buscarCidadePorNome(nome);
        if(cidadeAtual == null){
            System.out.println("Cidade nao encontrada.");
        }

    }
        while(true){

            for (Viagem v : fachada.listarViagem()) {
                System.out.println(v.toString());
            }

            System.out.println("\033[42;30m======== MENU - Cidade " + cidadeAtual.nome + " ========\033[0m");

            System.out.println("Qual caminho deseja seguir no sistema?");
            System.out.println("1 - Cidade");
            System.out.println("2 - Cliente");
            System.out.println("3 - Motorista");
            System.out.println("4 - Ajuda");
            opcao = Integer.parseInt(scanner.nextLine());
            opcaomenor = 0;
            switch(opcao){
                case 2:
                    while (opcaomenor != -1) {
                        System.out.println("1 - Login/Pedir Viagem");
                        System.out.println("2 - Buscar Cliente");
                        System.out.println("3 - Listar Clientes");
                        System.out.println("4 - Cadastrar Cliente");
                        System.out.println("5 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor) {
                            case 1:
                                System.out.println("CPF: ");
                                cpf = scanner.nextLine();
                                System.out.println("Senha: ");
                                senha = scanner.nextLine();
                                try {
                                    clienteAtivo = fachada.autenticarCliente(cpf, senha);
                                }catch (EntidadeNaoExisteException e){
                                    e.printStackTrace();
                                    continue;
                                }

                                System.out.println("BEM VINDO " + clienteAtivo.getNome().toUpperCase());
                                System.out.println("Qual o tipo de Viagem Deseja Fazer?(Passageiro / Entrega)");
                                String tipoDeViagem = scanner.nextLine().toUpperCase();
                                TipoDeViagem tipoViagem;
                                try {
                                    tipoViagem = TipoDeViagem.valueOf(tipoDeViagem);
                                }catch (IllegalArgumentException e) {
                                    System.out.println("Opção inválida! Use Passageiro ou Entrega");
                                    continue;
                                }
                                System.out.println("Qual o tipo de Veiculo? (SUV, ECONOMICO, LUXO, MOTOCICLETA) ");
                                String tipoDeVeiculo = scanner.nextLine().toUpperCase();
                                TipoVeiculo tipoVeiculo;
                                try {
                                    tipoVeiculo = TipoVeiculo.valueOf(tipoDeVeiculo);
                                }catch (IllegalArgumentException e) {
                                    System.out.println("Opção inválida! Use SUV, ECONOMICO, LUXO, MOTOCICLETA");
                                    continue;
                                }
                                System.out.println();
                                System.out.println("Buscando...");
                                System.out.println();

                                Motorista motorista_aux = fachada.buscarMotoristaDisponivel(tipoVeiculo);
                                if(motorista_aux == null){
                                    System.out.println("Nenhum motorista disponivel para essa viagem no momento.");
                                    System.out.println("Tente novamente mais tarde.");
                                }else {
                                    System.out.println("Origem:");
                                    String nomeOrigem = scanner.nextLine();
                                    String enderecoOrigem = scanner.nextLine();
                                    System.out.println("Destino");
                                    String nomeDestino = scanner.nextLine();
                                    String enderecoDestino = scanner.nextLine();
                                    fachada.adicionarViagem(new Viagem(cidadeAtual, new Local(nomeOrigem, enderecoOrigem), new Local(nomeDestino, enderecoDestino), motorista_aux, clienteAtivo, tipoViagem));
                                    System.out.println("Pedido de viagem feito, aguarde o motorista");
                                    System.out.println();
                                    System.out.println();
                                }
                                break;

                            case 2:
                                System.out.print("CPF: ");
                                cpf = scanner.nextLine();
                                Cliente c = fachada.buscarClientePorCpf(cpf);
                                if (c != null) {
                                    System.out.println(c.toString());
                                } else {
                                    System.out.println("Cliente não encontrado.");
                                }
                                break;

                            case 3:
                                System.out.println("Clientes Cadastrados:");
                                for (Cliente cliente : fachada.listarCliente()) {
                                    System.out.println(cliente.toString());
                                }
                            break;
                            case 4:
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                cpf = scanner.nextLine();
                                System.out.print("Idade: ");
                                int idade;
                                try {
                                    idade = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Idade inválida! Deve ser um número inteiro.");
                                    continue;
                                }

                                System.out.print("Sexo: ");
                                String sexo = scanner.nextLine();
                                System.out.println("Senha: ");
                                 senha = scanner.nextLine();
                                fachada.adicionarCliente(nome, cpf, idade, sexo, senha);
                                System.out.println("Cliente cadastrado com sucesso!");
                                break;

                            case 5:
                                opcaomenor = -1;
                                break;
                        }
                    }
                //fim case 1
                break;

                case 3:
                    while (opcaomenor != -1) {
                        System.out.println("1 - Login");
                        System.out.println("2 - Buscar Motorista");
                        System.out.println("3 - Listar Motorista");
                        System.out.println("4 - Cadastrar Motorista");
                        System.out.println("5 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor){
                            case 1:
                                System.out.println("CNH: ");
                                cnh = scanner.nextLine();
                                System.out.println("Senha: ");
                                senha = scanner.nextLine();
                                try {
                                    motoristaAtivo = fachada.autenticarMotorista(cnh, senha);
                                }catch (EntidadeNaoExisteException e){
                                    e.printStackTrace();
                                    continue;
                                }
                                System.out.println("BEM VINDO " + motoristaAtivo.getNome().toUpperCase());

                                break;

                            case 2:
                                System.out.print("CNH: ");
                                cnh = scanner.nextLine();
                                Motorista motorista = fachada.buscarMotoristaPorCNH(cnh);
                                if (motorista != null) {
                                    System.out.println(motorista.toString());
                                } else {
                                    System.out.println("Motorista não encontrado.");
                                }
                                break;
                            case 3:
                                System.out.println("Motoristas Cadastrados:");
                                for (Motorista m : fachada.listarMotorista()) {
                                    System.out.println(m.toString());
                                }

                                break;
                            case 4:
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                cpf = scanner.nextLine();
                                System.out.println("Senha: ");
                                senha = scanner.nextLine();
                                System.out.print("Idade: ");
                                int idade;
                                try {
                                    idade = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Idade inválida! Deve ser um número inteiro.");
                                    continue;
                                }
                                System.out.println("CNH :");
                                cnh = scanner.nextLine();
                                System.out.print("Sexo: ");
                                String sexo = scanner.nextLine();
                                System.out.println("Tipo de Veiculo(SUV, ECONOMICO, LUXO, MOTOCICLETA): ");
                                String tipo = scanner.nextLine().toUpperCase();
                                TipoVeiculo tipoVeiculo;
                                try {
                                    tipoVeiculo = TipoVeiculo.valueOf(tipo);
                                }catch (IllegalArgumentException e) {
                                    System.out.println("Opção inválida! Use SUV, ECONOMICO, LUXO, MOTOCICLETA");
                                    continue;
                                }
                                System.out.println("Placa do Veiculo :");
                                String placa = scanner.nextLine();
                                System.out.print("Modelo do Veiculo: ");
                                String modelo = scanner.nextLine();
                                System.out.print("Cor do Veiculo: ");
                                String cor = scanner.nextLine();
                                fachada.adicionarMotorista(nome, cpf, idade, sexo, cnh ,new Veiculo(placa, tipoVeiculo , cor ,modelo), senha);
                                System.out.println("Motorista cadastrado com sucesso!");

                                break;
                            case 5:
                                opcaomenor = -1;
                                break;
                        }
                    }
                //fim case 2
                break;
            }



        }

    }
}

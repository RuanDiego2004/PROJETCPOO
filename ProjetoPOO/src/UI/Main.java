package UI;

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
                        System.out.println("1 - Cadastrar Cliente");
                        System.out.println("2 - Buscar Cliente");
                        System.out.println("3 - Listar Clientes");
                        System.out.println("4 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor) {
                            case 1:
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
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
                                fachada.adicionarCliente(nome, cpf, idade, sexo);
                                System.out.println("Cliente cadastrado com sucesso!");
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
                                opcaomenor = -1;
                                break;
                        }
                    }
                //fim case 1
                break;

                case 3:
                    while (opcaomenor != -1) {
                        System.out.println("1 - Cadastrar Motorista");
                        System.out.println("2 - Buscar Motorista");
                        System.out.println("3 - Listar Motorista");
                        System.out.println("4 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor){
                            case 1:
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Idade: ");
                                int idade;
                                try {
                                    idade = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Idade inválida! Deve ser um número inteiro.");
                                    continue;
                                }
                                System.out.println("CNH :");
                                String cnh = scanner.nextLine();
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
                                fachada.adicionarMotorista(nome, cpf, idade, sexo, cnh ,new Veiculo(placa, tipoVeiculo , cor ,modelo) );
                                System.out.println("Motorista cadastrado com sucesso!");
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
                                opcaomenor = -1;
                                break;
                        }
                    }
                //fim case 2
                break;
            }



        }

    /*while (true) {
        System.out.println("Para ");
        System.out.println("\n==== MENU ====");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Buscar Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("4. Cadastrar Motorista");
        System.out.println("5. Buscar Motorista");
        System.out.println("6. Listar Motorista");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");

        int opcao;
        try {
            opcao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida! Digite um número.");
            continue;  // Retorna ao início do loop
        }

        if (opcao == 0) {
            System.out.println("Saindo...");
            break;
        }

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Idade: ");
                int idade;
                try {
                    idade = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Idade inválida! Deve ser um número inteiro.");
                    continue;
                }

                System.out.print("Sexo: ");
                String sexo = sc.nextLine();
                fachada.adicionarCliente(nome, cpf, idade, sexo);
                System.out.println("Cliente cadastrado com sucesso!");
                break;

            case 2:
                System.out.print("CPF: ");
                cpf = sc.nextLine();
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
                nome = sc.nextLine();
                System.out.print("CPF: ");
                cpf = sc.nextLine();
                System.out.print("Idade: ");
                try {
                    idade = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Idade inválida! Deve ser um número inteiro.");
                    continue;
                }
                System.out.println("CNH :");
                String cnh = sc.nextLine();
                System.out.print("Sexo: ");
                sexo = sc.nextLine();
                System.out.println("Tipo de Veiculo(SUV, ECONOMICO, LUXO, MOTOCICLETA): ");
                String tipo = sc.nextLine().toUpperCase();
                TipoVeiculo tipoVeiculo;
                try {
                    tipoVeiculo = TipoVeiculo.valueOf(tipo);
                }catch (IllegalArgumentException e) {
                    System.out.println("Opção inválida! Use SUV, ECONOMICO, LUXO, MOTOCICLETA");
                    continue;
                }
                System.out.println("Placa do Veiculo :");
                String placa = sc.nextLine();
                System.out.print("Modelo do Veiculo: ");
                String modelo = sc.nextLine();
                System.out.print("Cor do Veiculo: ");
                String cor = sc.nextLine();
                fachada.adicionarMotorista(nome, cpf, idade, sexo, cnh ,new Veiculo(placa, tipoVeiculo , cor ,modelo) );
                System.out.println("Motorista cadastrado com sucesso!");





                break;
            case 5:
                System.out.print("CNH: ");
                cnh = sc.nextLine();
                Motorista motorista = fachada.buscarMotoristaPorCNH(cnh);
                if (motorista != null) {
                    System.out.println(motorista.toString());
                } else {
                    System.out.println("Motorista não encontrado.");
                }
                break;
            case 6:
                System.out.println("Motoristas Cadastrados:");
                for (Motorista m : fachada.listarMotorista()) {
                    System.out.println(m.toString());
                }

                break;

            default:
                System.out.println("Opção inválida! Escolha um número do menu.");
        }
    }
    */





        /*
        fachada.adicionarViagem();
        for(Viagem v : fachada.listarViagem()) {
            System.out.println(v.toString());
        }
        Cidade cidade02 = new Cidade("Iati");
        System.out.println("For \n------------");
        for(Viagem v : fachada.listarPorCidade(cidade02)){

            System.out.println(v.toString());
        }
        fachada.adicionarCidade(cidade02);
        System.out.println("-----------");
        System.out.println(fachada.buscarCidadePorNome("Iati").toString());

        }
        */

    }
}

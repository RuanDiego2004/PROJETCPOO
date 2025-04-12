package UI;

import Negocio.*;
import Negocio.Basicas.*;
import Negocio.Fachada;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Fachada fachada = new Fachada();
        Cidade cidadeAtual = null;
        Cliente clienteAtivo = null;
        Motorista motoristaAtivo = null;
        List<Motorista> motoristasProcurandoCorrida = new ArrayList<Motorista>();


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
            }catch (CidadeJaExisteException e){
                System.out.println(e.getMessage());
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

        for(Viagem v: fachada.listarViagem()){
            System.out.println(v.toString());
        }

        while(true){



            System.out.println("\033[42;30m======== MENU - Cidade " + cidadeAtual.nome + " ========\033[0m");

            System.out.println("Qual caminho deseja seguir no sistema?");
            System.out.println("1 - Cadastrar-se");
            System.out.println("2 - Cidade");
            System.out.println("3 - Cliente");
            System.out.println("4 - Motorista");
            System.out.println("5 - Ajuda");
            System.out.println("6 - Encerrar programa");

            opcao = Integer.parseInt(scanner.nextLine());

            opcaomenor = 0;
            clienteAtivo = null;
            motoristaAtivo = null;

            switch(opcao){
                case 1:
                    while(opcaomenor != -1){
                        System.out.println("Voce deseja se cadastrar como cliente ou motorista?");
                        System.out.println("1 - Cliente");
                        System.out.println("2 - Motorista");
                        System.out.println("3 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor){
                            case 1:
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
                                try {
                                    fachada.adicionarCliente(nome, cpf, idade, sexo, senha);
                                    System.out.println("Cliente cadastrado com sucesso!");
                                }catch (CPFJaUtilizadoException e){
                                    System.out.println(e.getMessage());
                                }
                            break;
                            case 2:
                                System.out.print("Nome: ");
                                String nomeMotorista = scanner.nextLine();
                                System.out.print("CPF: ");
                                cpf = scanner.nextLine();
                                System.out.println("Senha: ");
                                senha = scanner.nextLine();
                                System.out.print("Idade: ");
                                int idadeMotorista;
                                try {
                                    idadeMotorista = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Idade inválida! Deve ser um número inteiro.");
                                    continue;
                                }
                                System.out.println("CNH :");
                                cnh = scanner.nextLine();
                                System.out.print("Sexo: ");
                                String sexoMotorista = scanner.nextLine();
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
                                try {
                                    fachada.adicionarMotorista(nomeMotorista, cpf, idadeMotorista, sexoMotorista, cnh, new Veiculo(placa, tipoVeiculo, cor, modelo), senha);
                                    System.out.println("Motorista cadastrado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            break;
                            case 3:
                                opcaomenor = -1;
                            break;
                        }
                    }

                break;
                case 2:
                    while(opcaomenor != -1){
                        System.out.println("Oque deseja fazer?");
                        System.out.println("1 - Adicionar cidade");
                        System.out.println("2 - Listar cidades");
                        System.out.println("3 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor){
                        case 1:
                            System.out.println("Digite o nome da cidade que deseja cadastrar: ");
                            String nomeCidade = scanner.nextLine();
                            try{
                                fachada.adicionarCidade(new Cidade(nomeCidade));
                            }catch (CidadeJaExisteException e){
                                System.out.println(e.getMessage());
                            }
                        break;
                        case 2:
                            for(Cidade c : fachada.listarCidade()){
                                System.out.println(c.toString());
                            }
                        break;
                        case 3:
                            opcaomenor = -1;
                        break;
                        }
                    }


                break;
                case 3:
                    while (opcaomenor != -1) {
                        System.out.println("\033[47;30m CLIENTES " + cidadeAtual.nome.toUpperCase() + " \033[0m");
                        if(clienteAtivo != null) {
                            System.out.print("Cliente ativo: " + clienteAtivo.getNome() + "\n");
                        }

                        System.out.println("1 - Login");
                        System.out.println("2 - Fazer Corrida");
                        System.out.println("3 - Adicionar cartão");
                        System.out.println("4 - Listar cartões");
                        System.out.println("5 - Listar corridas feitas");
                        System.out.println("6 - Visualizar motoristas disponiveis");
                        System.out.println("7 - Voltar");

                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch(opcaomenor) {
                            case 1:
                                System.out.println("CPF: ");
                                cpf = scanner.nextLine();
                                System.out.println("Senha: ");
                                senha = scanner.nextLine();
                                try {
                                    clienteAtivo = fachada.autenticarCliente(cpf, senha);
                                }catch (LoginInvalidoException e){
                                    System.out.println(e.getMessage());
                                    continue;
                                }
                                System.out.println("Login realizado com sucesso.");
                                break;

                            case 2:
                                if(clienteAtivo == null){
                                    System.out.println("Precisa fazer login para pedir uma corrida.");
                                }
                                else {

                                    if (motoristasProcurandoCorrida.isEmpty()) {
                                        System.out.println("Nenhum motorista disponivel para essa viagem no momento.");
                                        System.out.println("Tente novamente mais tarde.");
                                    } else {
                                        try{

                                            System.out.println("Qual o tipo de Viagem Deseja Fazer?(Passageiro / Entrega)");
                                            String tipoDeViagem = scanner.nextLine().toUpperCase();
                                            TipoDeViagem tipoViagem;
                                            tipoViagem = TipoDeViagem.valueOf(tipoDeViagem);

                                            System.out.println("Qual o tipo de Veiculo? (SUV, ECONOMICO, LUXO, MOTOCICLETA) ");
                                            String tipoDeVeiculo = scanner.nextLine().toUpperCase();
                                            TipoVeiculo tipoVeiculo;
                                            tipoVeiculo = TipoVeiculo.valueOf(tipoDeVeiculo);

                                            boolean validarMotorista = false;
                                            Motorista motoristaCorrida = null;
                                            for(Motorista mo: motoristasProcurandoCorrida){
                                                if(mo.getVeiculo().getTipo().equals(tipoVeiculo)){
                                                    motoristaCorrida = mo;
                                                    validarMotorista = true;
                                                    break;
                                                }
                                            }
                                            if(validarMotorista == false) throw new Exception("Não existe nenhum motorista com esse tipo de veiculo disponivel.");

                                            System.out.println("Motorista encontrado!");
                                            System.out.println("Nome " + motoristaCorrida.getNome());
                                            System.out.println("Veiculo: \n" + motoristaCorrida.getVeiculo().toString());


                                            System.out.println("Informações da corrida: ");

                                            System.out.println("Digite o nome do local de origem");
                                            String nomeOrigem = scanner.nextLine();
                                            System.out.println("endereço origem: ");
                                            String enderecoOrigem = scanner.nextLine();
                                            System.out.println("Digite o nome do local de destino");
                                            String nomeDestino = scanner.nextLine();
                                            System.out.println("endereço destino: ");
                                            String enderecoDestino = scanner.nextLine();

                                            // inicio forma de pagamento
                                            System.out.println("Escolha a forma de pagamento");
                                            System.out.println("Dinheiro,Pix ou Cartao");
                                            String formaDePagamento = scanner.nextLine();
                                            fachada.validarFormaDePagamento(formaDePagamento);
                                            // validou se é dinheiro, pix ou cartao


                                            Viagem viagemTemp = new Viagem(cidadeAtual, new Local(nomeOrigem, enderecoOrigem), new Local(nomeDestino, enderecoDestino), motoristaCorrida, clienteAtivo, tipoViagem, new FormaDePagamento(formaDePagamento));
                                            // criou a viagem

                                            // se forma de pagamento for cartão
                                            if (formaDePagamento.equalsIgnoreCase("Cartao")) {
                                                // cliente nao tem cartao
                                                if (clienteAtivo.getCartoes().isEmpty()) {
                                                    throw new ClienteNaoTemCartaoException();
                                                }
                                                // validar cartao do cliente
                                                else {
                                                    System.out.println("Qual o numero do cartão que deseja usar?");
                                                    int numeroCartao = Integer.parseInt(scanner.nextLine());
                                                    Cartao tempCartao = fachada.verificarNumCartao(clienteAtivo, numeroCartao);
                                                    // cartão validado, verificar se tem saldo
                                                    fachada.validarPagamento(tempCartao, viagemTemp.getValor());
                                                }
                                            }
                                            // se todas verificacoes foram bem
                                            // Dinheiro pix ou cartao
                                            // se for cartão se cliente tem cartão
                                            //se tiver cartão se tem limite suficiente
                                            //a viagem é adicionada, se não, graças as excecoes nao é adicionada.
                                            fachada.adicionarViagem(viagemTemp);
                                            motoristasProcurandoCorrida.remove(motoristaCorrida);
                                            System.out.println("Pedido de viagem feito, aguarde o motorista");
                                            fachada.salvarCliente();
                                            System.out.println();

                                            System.out.println("Avalie o motorista");
                                            double ava = Double.parseDouble(scanner.nextLine());
                                            fachada.avaliarViagemMotorista(ava,motoristaCorrida);

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }

                                    }
                                }
                                break;
                            case 3:
                                if(clienteAtivo == null){
                                    System.out.println("\033[31mFaça login para adicionar cartão\033[0m");
                                }
                                else{
                                    try{
                                    System.out.println("Digite o numero do cartão");
                                    int numeroCartao = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Digite a senha do cartao");
                                    int senhaCartao = Integer.parseInt(scanner.nextLine());

                                    System.out.println("Digite o limite do cartao");
                                    double limite = Double.parseDouble(scanner.nextLine());
                                    fachada.adicionarCartão(clienteAtivo,numeroCartao,senhaCartao,limite);
                                    }catch(Exception e){
                                        System.out.println(e.getMessage());
                                    }

                                }
                            break;
                            case 4:
                                if(clienteAtivo == null){
                                    System.out.println("\033[31mFaça login para listar cartões\033[0m");
                                }
                                else{
                                    if(clienteAtivo.cartoes.isEmpty()){
                                        System.out.println("Não possui nenhum cartão.");
                                        continue;
                                    }
                                    for(Cartao c : clienteAtivo.getCartoes()){
                                        System.out.println(c.toString());
                                    }
                                }
                            break;

                            case 5:
                                if(clienteAtivo == null){
                                    System.out.println("\033[31mFaça login para listar corridas feitas\033[0m");
                                }
                                else{
                                    try{
                                        if(fachada.listarViagensPorCliente(clienteAtivo).isEmpty()){
                                            System.out.println("Não fez nenhuma viagem.");
                                            continue;
                                        }
                                        for(Viagem vi : fachada.listarViagensPorCliente(clienteAtivo)){
                                            System.out.println(vi.toString());
                                        }
                                    }catch(Exception e){
                                        System.out.println(e.getMessage());
                                    }
                                }
                            break;

                            case 6:
                                if(motoristasProcurandoCorrida.isEmpty()){
                                    System.out.println("Nenhum motorista procurando corrida...");
                                    System.out.println("Tente novamente mais tarde");
                                }
                                else{
                                    for(Motorista m : motoristasProcurandoCorrida){
                                        System.out.println("Nome do motorista "+ m.getNome());
                                        System.out.println("Veiculo do motorista\n" + m.getVeiculo().toString());
                                    }
                                }
                            break;
                            case 7:
                                opcaomenor = -1;
                                break;
                        }
                    }
                //fim case 1
                break;

                case 4:
                    while (opcaomenor != -1) {
                        System.out.println("\033[47;30m MOTORISTAS " + cidadeAtual.nome.toUpperCase() + "\033[0m");
                        if(motoristaAtivo != null)
                            System.out.println("Motorista ativo: " + motoristaAtivo.getNome());
                        System.out.println("1 - Login");
                        System.out.println("2 - Fazer corrida");
                        System.out.println("3 - Cancelar procura por corrida");
                        System.out.println("4 - Buscar viagens feitas");
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
                                }catch (LoginInvalidoException e){
                                    e.getMessage();
                                    continue;
                                }

                                break;


                            case 2:
                                if(motoristaAtivo == null) {
                                    System.out.println("Faça login para fazer uma corrida!");
                                }

                                // após logado
                                else{
                                    if(motoristasProcurandoCorrida.contains(motoristaAtivo)){
                                        System.out.println("Motorista " +motoristaAtivo.getNome() +" ja está procurando corrida.");
                                    }
                                    else{
                                        motoristasProcurandoCorrida.add(motoristaAtivo);
                                        System.out.println("Motorista " +motoristaAtivo.getNome() +" agora está disponivel para realizar uma corrida!");
                                    }
                                }


                            break;

                            case 3:
                                if(motoristaAtivo == null) {
                                    System.out.println("Faca login para cancelar a busca por uma corrida!");
                                }
                                // após logado
                                else{
                                    // se motorista estiver na lista
                                    if(motoristasProcurandoCorrida.contains(motoristaAtivo)){
                                        motoristasProcurandoCorrida.remove(motoristaAtivo);
                                        System.out.println("Motorista " +motoristaAtivo.getNome() +" nao está mais procurando corrida!");
                                    }
                                    else{
                                        // se motorista não estiver na lista
                                        System.out.println("Motorista não está procurando corrida.");
                                    }
                                }
                            break;
                            case 4:
                                if(motoristaAtivo == null){
                                    System.out.println("\033[31mFaça login para listar corridas feitas\033[0m");
                                }
                                else{
                                    try{
                                        if(fachada.listarViagensPorMotorista(motoristaAtivo).isEmpty()){
                                            System.out.println("Não fez nenhuma viagem.");
                                            continue;
                                        }
                                        for(Viagem vi : fachada.listarViagensPorMotorista(motoristaAtivo)){
                                            System.out.println(vi.toString());
                                        }
                                    }catch(Exception e){
                                        System.out.println(e.getMessage());
                                    }
                                }
                            break;
                            case 5:
                                opcaomenor = -1;
                                break;
                        }
                    }
                break;
                case 5:
                    System.out.println("Bem vindo ao menu ajuda!");
                    while(opcaomenor != -1) {
                        System.out.println("Escolha uma opcao: ");
                        System.out.println("1 - Cliente: como pedir uma corrida");
                        System.out.println("2 - Motorista: como fazer uma corrida");
                        System.out.println("3 - Listar os motoristas do sistema");
                        System.out.println("4 - Listar os clientes do sistema");
                        System.out.println("5 - Voltar");
                        opcaomenor = Integer.parseInt(scanner.nextLine());
                        switch (opcaomenor){
                            case 1:
                                System.out.println("Para pedir uma corrida, o primeiro passo que se deve fazer é o login.");
                                System.out.println("Caso não esteja cadastrado, faça o \033[32mcadastro\033[0m no menu adequado e logo em seguida volte e entre no menu \033[32mCliente\033[0m.");
                                System.out.println("Ao entrar no menu \033[32mCliente\033[0m, faça o login com o \033[34mCPF\033[0m e a \033[34mSENHA\033[0m que usou para o \033[32mcadastro\033[0m.");
                                System.out.println("Após o login, selecione a opção de \033[35mpedir corrida\033[0m.");
                                System.out.println("Caso não tenha \033[31mnenhum motorista disponivel\033[0m, volte novamente mais tarde.");
                                System.out.println("Caso o contrario, preencha as infomações da corrida que deseja fazer e \033[32mpronto\033[0m!");
                            break;
                            case 2:
                                System.out.println("Para fazer uma corrida, o primeiro passo que se deve fazer é o login.");
                                System.out.println("Caso não esteja cadastrado, faça o \033[32mcadastro\033[0m no menu adequado e logo em seguida volte e entre no menu \033[32mMotorista\033[0m.");
                                System.out.println("Ao entrar no menu \033[32mMotorista\033[0m, faça o login com a \033[34mCNH\033[0m e a \033[34mSENHA\033[0m que usou para o \033[32mcadastro\033[0m.");
                                System.out.println("Após o login, selecione a opção de \033[35mfazer corrida\033[0m.");
                                System.out.println("\033[32mPronto\033[0m, agora basta esperar um cliente!!");
                            break;
                            case 3:
                                for(Cliente cli : fachada.listarCliente())
                                    System.out.println(cli.toString());
                            break;
                            case 4:
                                for(Motorista mo : fachada.listarMotorista())
                                    System.out.println(mo.toString());
                            break;
                            case 5:
                                opcaomenor = -1;
                            break;
                        }
                    }
                break;
                case 6:
                    exit(0);
                break;


            }
        }

    }
}

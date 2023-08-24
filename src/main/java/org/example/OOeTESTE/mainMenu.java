package org.example.OOeTESTE;

import org.example.OOeTESTE.entidades.ContaBancaria;
import org.example.OOeTESTE.entidades.ContaEspecial;
import org.example.OOeTESTE.entidades.ContaPoupanca;
import org.example.OOeTESTE.entidades.TIPOCONTA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class mainMenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<ContaBancaria> listaContaBancaria = new ArrayList<>(Arrays.asList(
                new ContaBancaria("Ana Silva", "001", 8500, TIPOCONTA.CORRENTE),
                new ContaBancaria("Carlos Pereira", "002", 12000, TIPOCONTA.CORRENTE),
                new ContaBancaria("Beatriz Almeida", "003", 9500, TIPOCONTA.CORRENTE)
        ));

        List<ContaEspecial> listaContaEspecial = new ArrayList<>(Arrays.asList(
                new ContaEspecial("Eduardo Costa", "004", 14500, TIPOCONTA.CONTA_ESPECIAL),
                new ContaEspecial("Fernanda Rocha", "005", 7000, TIPOCONTA.CONTA_ESPECIAL),
                new ContaEspecial("Gustavo Moraes", "006", 13500, TIPOCONTA.CONTA_ESPECIAL)
        ));

        List<ContaPoupanca> listaContaPoupanca = new ArrayList<>(Arrays.asList(
                new ContaPoupanca("Helena Santos", "007", 6500, TIPOCONTA.POUPANCA),
                new ContaPoupanca("Igor Ribeiro", "008", 11500, TIPOCONTA.POUPANCA),
                new ContaPoupanca("Juliana Andrade", "009", 2000, TIPOCONTA.POUPANCA)
        ));

        while (true) {
            System.out.println("Digite a Operação que deseja realizar: ");
            System.out.println("1. Adicionar Conta Bancária");
            System.out.println("2. Listar Conta Bancária");
            System.out.println("3. Realizar Operação Bancária");
            System.out.println("9. Sair");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 9:
                    System.exit(0);
                    break;
                case 1:
                    try {
                        System.out.println("Digite: \n1. para Conta Corrente" +
                                "\n2. para Conta Poupança" +
                                "\n3. para Conta Especial" +
                                "\n0. para Voltar");
                        int escolha = sc.nextInt();
                        sc.nextLine();

                        if (escolha == 1 || escolha == 2 || escolha == 3) {
                            System.out.println("Digite o nome do usuário: ");
                            String nome = sc.nextLine();
                            System.out.println("Digite o número da conta: ");
                            String num = sc.nextLine();
                            System.out.println("Digite o saldo inicial (depósito inicial): ");
                            double saldo = sc.nextDouble();

                            if (escolha == 1) {
                                ContaBancaria conta = new ContaBancaria(nome, num, saldo, TIPOCONTA.CORRENTE);
                                listaContaBancaria.add(conta);
                            } else if (escolha == 2) {
                                ContaPoupanca contaPoupanca = new ContaPoupanca(nome, num, saldo, TIPOCONTA.POUPANCA);
                                listaContaPoupanca.add(contaPoupanca);
                            } else if (escolha == 3) {
                                ContaEspecial contaEspecial = new ContaEspecial(nome, num, saldo, TIPOCONTA.CONTA_ESPECIAL);
                                listaContaEspecial.add(contaEspecial);
                            }
                            break;
                        } else if (escolha == 0) {
                            break;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Digite um número de 1 a 3!");
                    }
                default:
                    System.out.println("Número inválido.");
                    break;

                case 2:
                    System.out.println("Digite: " +
                            "\n1. para listar Contas Correntes" +
                            "\n2. para listar Contas Poupanças" +
                            "\n3. para listar Contas Especiais" +
                            "\n0. para Voltar");
                    int escolha = sc.nextInt();
                    sc.nextLine();

                    switch (escolha) {
                        case 1 -> {
                            for (ContaBancaria conta : listaContaBancaria) {
                                System.out.println(conta);
                            }

                        }
                        case 2 -> {
                            for (ContaPoupanca conta : listaContaPoupanca) {
                                System.out.println(conta);
                            }

                        }
                        case 3 -> {
                            for (ContaEspecial conta : listaContaEspecial) {
                                System.out.println(conta);
                            }

                        }
                        default -> System.out.println("Opção inválida!");


                    }
                    break;

                case 3:
                    System.out.println("Digite: " +
                            "\n1. DEPÓSITO" +
                            "\n2. SAQUE" +
                            "\n0. para Voltar");
                    int op = sc.nextInt();
                    sc.nextLine();

                    switch (op) {
                        case 1:
                            System.out.println("Digite o número da conta que deseja depositar: ");
                            String numconta = sc.nextLine();

                            // Verificação se a conta existe
                            boolean existe = listaContaBancaria.stream().anyMatch(conta -> conta.getNumConta().equals(numconta)) ||
                                    listaContaEspecial.stream().anyMatch(conta -> conta.getNumConta().equals(numconta)) ||
                                    listaContaPoupanca.stream().anyMatch(conta -> conta.getNumConta().equals(numconta));

                            if (!existe) {
                                System.out.println("Número de conta não encontrado.");
                            } else {
                                System.out.println("Digite o valor que deseja depositar: ");
                                double valor = sc.nextDouble();
                                sc.nextLine();

                                // depósito com for
                                for (ContaBancaria conta : listaContaBancaria) {
                                    if (conta.getNumConta().equals(numconta)) {
                                        conta.depositar(valor);
                                    }

                                }
                                for (ContaEspecial conta : listaContaEspecial) {
                                    if (conta.getNumConta().equals(numconta)) {
                                        conta.depositar(valor);
                                    }
                                }
                                for (ContaPoupanca conta : listaContaPoupanca) {
                                    if (conta.getNumConta().equals(numconta)) {
                                        conta.depositar(valor);
                                    }
                                }
                            }

                            case 2:
                                System.out.println("Digite o número da conta origem do saque: ");
                                String numcontaSaque = sc.nextLine();

                                // Verificação se a conta existe
                                boolean existeContaSaque = listaContaBancaria.stream().anyMatch(conta -> conta.getNumConta().equals(numcontaSaque)) ||
                                        listaContaEspecial.stream().anyMatch(conta -> conta.getNumConta().equals(numcontaSaque)) ||
                                        listaContaPoupanca.stream().anyMatch(conta -> conta.getNumConta().equals(numcontaSaque));

                                if (!existeContaSaque) {
                                    System.out.println("Número de conta não encontrado.");
                                } else {
                                    System.out.println("Digite o valor que deseja sacar: ");
                                    double valor = sc.nextDouble();
                                    sc.nextLine();


                                    //saque com stream
                                    listaContaBancaria.stream()
                                            .filter(conta -> conta.getNumConta().equals(numcontaSaque))
                                            .forEach(conta -> conta.sacar(conta, valor));

                                    listaContaEspecial.stream()
                                            .filter(conta -> conta.getNumConta().equals(numcontaSaque))
                                            .forEach(conta -> conta.sacar(conta, valor));

                                    listaContaPoupanca.stream()
                                            .filter(conta -> conta.getNumConta().equals(numcontaSaque))
                                            .forEach(conta -> conta.sacar(conta, valor));

                                }
                            }
                        }
                    }
            }
        }


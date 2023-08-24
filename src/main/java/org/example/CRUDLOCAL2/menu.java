package org.example.CRUDLOCAL2;

import java.util.Scanner;

public class menu {

    private Scanner sc = new Scanner(System.in);
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void exibirMenu() {
        while (true) {
            System.out.println("Bem vindo ao menu de Clientes!\nPor favor, selecione a opção desejada:" +
                    "\n1. Adicionar Cliente." +
                    "\n2. Alterar Cliente." +
                    "\n3. Listar Clientes." +
                    "\n4. Deletar Cliente." +
                    "\n0. Sair.");

            int op = sc.nextInt();
            sc.nextLine();
            switch (op) {

                case 1 -> {
                    System.out.println("Digite o Nome do Cliente: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite o salário do Cliente: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    Cliente c = new Cliente(nome, salario);
                    clienteDAO.addCliente(c);
                }
                case 2 -> {
                    System.out.println("Digite o ID do cliente que deseja alterar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o novo nome do cliente: ");
                    String nome = sc.nextLine();

                    System.out.println("Digite o novo salário do cliente: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    clienteDAO.updateCliente(id,nome,salario);

                }
                case 3->{
                    System.out.println("Lista de Clientes:\n");
                    clienteDAO.getAll();
                }
                case 4->{
                    System.out.println("Digite o ID do cliente que deseja excluir: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    clienteDAO.removeClienteById(id);
                }
                case 0->{
                    System.out.println("Até breve!");
                    System.exit(0);
                }


            }

        }
    }
}
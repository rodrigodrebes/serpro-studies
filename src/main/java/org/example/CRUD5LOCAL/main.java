package org.example.CRUD5LOCAL;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("MENU");
            System.out.println("1. Criar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Buscar usuário por ID");
            System.out.println("4. Deletar usuário por ID");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nome: ");
                    String name = scanner.next();
                    System.out.print("Idade: ");
                    int age = scanner.nextInt();
                    System.out.print("Salário: ");
                    double salary = scanner.nextDouble();

                    userController.createUser(name, age, salary);
                    System.out.println("Usuário criado com sucesso!");
                    break;

                case 2:
                    for (User user : userController.listUsers()) {
                        System.out.println(user);
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do usuário: ");
                    int id = scanner.nextInt();
                    User user = userController.getUser(id);
                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do usuário que você deseja deletar: ");
                    int userId = scanner.nextInt();
                    userController.deleteUser(userId);
                    System.out.println("Usuário deletado com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println("--------------------------");
        }
    }
}

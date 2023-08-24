package org.example.CRUD6ETESTS;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private TaskManager tm = new TaskManager();

    public void exibirMenu() {
        while (true) {
            System.out.println("Olá! Bem vindo ao menu de Tarefas!" +
                    "\nPor favor, selecione a opção desejada:" +
                    "\n1. Adicionar Tarefa" +
                    "\n2. Editar Tarefa" +
                    "\n3. Remover Tarefa" +
                    "\n4. Listar todas Tarefas" +
                    "\n0. Sair");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0 -> {
                    System.exit(0);
                }
                case 1 -> {
                    System.out.println("Digite o nome da Tarefa: ");
                    String title = sc.nextLine();
                    System.out.println("Digite a descrição: ");
                    String description = sc.nextLine();
                    System.out.println("Está completo? S/N: ");
                    String completed = sc.nextLine();

                    tm.addTask(title, description, completed);
                    System.out.println("Task adicionada com sucesso!");
                }
                case 2 -> {
                    System.out.println("Digite o ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome da Tarefa: ");
                    String title = sc.nextLine();
                    System.out.println("Digite a descrição: ");
                    String description = sc.nextLine();
                    System.out.println("Está completo? S/N: ");
                    String completed = sc.nextLine();

                    tm.updateTask(id, title, description, completed);
                }
                case 3 -> {
                    System.out.println("Digite o ID da tarefa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    tm.removeTaskById(id);
                }
                case 4 -> {
                    tm.getTasks();
                }
            }
        }
    }
}
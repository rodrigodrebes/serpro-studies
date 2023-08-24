package org.example.CRUD3;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws SQLException {
    // criamos a tabela, se não existe
    DB.createTable();

    // criamos instancia de PessoaDAO para acessar os métodos
        PessoaDAO pessoaDAO = new PessoaDAO();

    // menu funcional

        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.println("---------------");
            System.out.println("Bem-vindo ao menu de Pessoas");
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Editar Pessoa");
            System.out.println("3. Deletar Pessoa por ID");
            System.out.println("4. Listar todas as pessoas");
            System.out.println("5. Sair do Programa");
            System.out.println("Digite a opção desejada:");

            int op = sc.nextInt();
            sc.nextLine();


            switch (op){
                case 1:
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.println("Digite o nome da pessoa:");
                            String nome = sc.nextLine();

                            System.out.println("Digite a idade da pessoa:");
                            int idade = sc.nextInt();
                            sc.nextLine();  // limpa o buffer após ler um número

                            Pessoa pessoa = new Pessoa(null, nome, idade);
                            pessoaDAO.insert(pessoa);
                            System.out.println("Pessoa inserida com sucesso!");

                            validInput = true;  // sai do loop após a entrada bem-sucedida
                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas texto para nome e inteiros para idade!");
                            sc.nextLine();  // limpa o buffer se uma entrada inválida for fornecida
                        }
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID da pessoa que deseja atualizar nome e idade:");
                    int idInt = sc.nextInt();
                    sc.nextLine();
                    Long id = (long) idInt;
                    System.out.println("Digite o nome novo da pessoa: ");
                    String nome = sc.nextLine();
                    System.out.println("Digite a nova idade da pessoa:");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    Pessoa pessoaAtualizada = new Pessoa(id, nome, idade);
                    pessoaDAO.update(pessoaAtualizada);
                    break;

                case 3:
                    System.out.println("Digite o ID da pessoa que deseja deletar:");
                    id = (long) sc.nextInt();
                    sc.nextLine();
                    pessoaDAO.delete(id);
                    break;

                case 4:
                    List<Pessoa> pessoas = pessoaDAO.findPessoas();
                    for (Pessoa p : pessoas) {
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.println("Adeus!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }

    }
}

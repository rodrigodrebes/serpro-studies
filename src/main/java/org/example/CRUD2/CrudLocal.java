package org.example.CRUD2;

import java.util.*;
import java.util.stream.Collectors;



public class CrudLocal {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Livro> listaDeLivros = new ArrayList<>(Arrays.asList(
                new Livro("O Estrangeiro", "Albert Camus", 19.9),
                new Livro("Cem anos de Solidão", "Gabriel Garcia Marques", 20.99),
                new Livro("Pedro Paramo", "Juan", 5.99),
                new Livro("Detetives Selvagens", "Roberto Bolano", 39.9),
                new Livro("Ficções", "Jorge Borges", 51.9),
                new Livro("On The Road", "Jack Kerouac", 8.99)
                ));

        for (Livro livro : listaDeLivros){
            System.out.println("\n" + livro);
        }

        // Filtrando livros com preço menor que 10.0 (por exemplo)
        List<Livro> livrosComPrecoMenorQue10 = listaDeLivros.stream()
                .filter(livro -> livro.getPreco() < 10.0)
                .collect(Collectors.toList());

        // exibir os livros com preço menor que 10:
        System.out.println("\nLivros com preço menor que 10:");
        livrosComPrecoMenorQue10.forEach(System.out::println);


// livros ordenados por preço
        List<Livro> livrosOrdenadosPorPreco = listaDeLivros.stream()
                .sorted(Comparator.comparing(Livro::getPreco))
                .collect(Collectors.toList());

        System.out.println("Livros ordenados por preço em ordem crescente:");
        for(Livro livro : livrosOrdenadosPorPreco){
            System.out.println("\n"+ livro);
        }


        // menu para adicionar objetos na memória
        while(true){

            System.out.println("Digite o nome do livro ou 'sair' para encerrar: ");
            String nome = sc.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("Digite o autor do livro: ");
            String autor = sc.nextLine();

            double preco = 0;
            while (true) {
                try {
                    System.out.println("Digite o preco do livro: ");
                    preco = sc.nextDouble();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, digite um número válido para o preço.");
                    sc.nextLine();
                }
            }


            Livro livro = new Livro(nome, autor, preco);
            listaDeLivros.add(livro);

        }



    }
}

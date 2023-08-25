package org.example.LerArquivo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BufferedReader {

    public static void main(String[] args) {

        //LENDO ARQUIVO
        String path = "C:\\Users\\Rodrigo\\Desktop\\java\\serpro\\src\\main\\java\\org\\example\\LerArquivo2\\produtos.txt";

        List<Produto> produtoList = new ArrayList<>();

        try (java.io.BufferedReader br = new java.io.BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] vect = line.split(",");
                String nome = vect[0];
                double preco = Double.parseDouble(vect[1]);
                String marca = vect[2];

                Produto p = new Produto(nome, preco, marca);
                produtoList.add(p);

                line = br.readLine();
            }

            System.out.println("PRODUTOS: ");
            for (Produto p : produtoList) {
                System.out.println(p);
            }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        // SALVANDO EM NOVO ARQUIVO:
        String outputFilePath = "output.txt"; // Nome do arquivo de saída
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            // Escreva os resultados que você deseja salvar
            bw.write("PRODUTOS:");
            bw.newLine(); // Pular para a próxima linha

            // Supondo que você tenha uma lista de produtos
            for (Produto p : produtoList) {
                bw.write("Nome: " + p.getNome());
                bw.newLine();
                bw.write("Preço: " + p.getPreco());
                bw.newLine();
                bw.write("Marca: " + p.getMarca());
                bw.newLine();
                bw.write("-----");
                bw.newLine();
            }

            System.out.println("Resultados salvos em " + outputFilePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

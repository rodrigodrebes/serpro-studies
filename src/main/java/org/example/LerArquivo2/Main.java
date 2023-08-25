package org.example.LerArquivo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path ="C:\\Users\\Rodrigo\\Desktop\\java\\serpro\\src\\main\\java\\org\\example\\LerArquivo2\\produtos.txt";

        List<Produto> produtoList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            line= br.readLine();

            while(line!=null) {
                String[] vect = line.split(",");
                String nome = vect[0];
                double preco = Double.parseDouble(vect[1]);
                String marca = vect[2];

                Produto p = new Produto(nome, preco, marca);
                produtoList.add(p);

                line=br.readLine();
            }

            System.out.println("PRODUTOS: ");
            for(Produto p : produtoList){
                System.out.println(p);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

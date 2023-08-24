package org.example.LerArquivo.aplicacao;

import org.example.LerArquivo.entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        String path = "C:\\Users\\Rodrigo\\Desktop\\java\\arquivo\\documento.csv";

        // vamos transformar os dados em uma lista, através de objetos
        List<Produto> produtos = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine(); // pula a primeira linha, o cabeçalho
            line=br.readLine();
            while(line!=null){

                //transforma a frase inteira (linha) em um vetor, separando onde tem ","
                String[] vect = line.split(",");
                String nome = vect[0];
                Double preco = Double.parseDouble(vect[1]);
                Integer quantidade = Integer.parseInt(vect[2]);

                Produto prod = new Produto(nome, preco, quantidade);
                produtos.add(prod);


                line = br.readLine();
            }
            System.out.println("PRODUTOS: ");
            for (Produto p : produtos){
                System.out.println(p);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

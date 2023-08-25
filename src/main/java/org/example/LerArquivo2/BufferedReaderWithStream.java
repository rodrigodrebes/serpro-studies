package org.example.LerArquivo2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedReaderWithStream {
    public static void main(String[] args) {

        String path = "C:\\Users\\Rodrigo\\Desktop\\java\\serpro\\src\\main\\java\\org\\example\\LerArquivo2\\produtos.txt";

        try {
            List<Produto> produtoList = Files.lines(Paths.get(path))
                    .skip(1) // Pula a primeira linha
                    .map(line -> line.split(","))
                    .map(vect -> new Produto(vect[0], Double.parseDouble(vect[1]), vect[2]))
                    .collect(Collectors.toList());

            System.out.println("PRODUTOS: ");
            produtoList.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
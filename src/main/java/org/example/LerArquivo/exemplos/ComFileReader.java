package org.example.LerArquivo.exemplos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComFileReader {

    public static void main(String[] args) {

        String path = "C:\\Users\\Rodrigo\\Desktop\\java\\arquivo\\documento.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line=br.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

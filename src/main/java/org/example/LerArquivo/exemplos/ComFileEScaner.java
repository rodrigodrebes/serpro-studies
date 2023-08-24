package org.example.LerArquivo.exemplos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ComFileEScaner {
    public static void main(String[] args) {

        // lendo arquivos com FIle e Scanner

        File file = new File("C:\\Users\\Rodrigo\\Desktop\\java\\arquivo\\documento.csv");
        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if(sc!= null){
            sc.close();
            }
        }
    }
}

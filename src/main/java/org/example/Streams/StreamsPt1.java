package org.example.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsPt1 {

    public static void main(String[] args) {

        List<Funcionario> funcionarioList = new ArrayList<>(Arrays.asList(
                new Funcionario(1, "José da Silva", "1111-11111", 25),
                new Funcionario(2, "Maria dos santos", "2222-2222", 30),
                new Funcionario(3, "Ana Maria", "3333-3333", 22),
                new Funcionario(4, "Fabiana Maria Pereira", null, 55),
                new Funcionario(5, "Fabiana Maria Pereira", null, 55),
                new Funcionario(6, "Alberto Roberto", "4444-4444", 70)
        ));

//        //IMPRESSÃO SEM STREAM
//        for (Funcionario f:funcionarioList){
//            System.out.println(f);
//        }

        //IMPRESSÃO COM STREAMS
        funcionarioList.stream()
                .forEach(System.out::println);
    }
}

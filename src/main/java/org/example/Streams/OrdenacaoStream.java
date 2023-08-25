package org.example.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoStream {
    public static void main(String[] args) {
        List<Funcionario> funcionarioList = new ArrayList<>(Arrays.asList(
                new Funcionario(1, "José da Silva", "1111-11111", 25),
                new Funcionario(2, "Maria dos santos", "2222-2222", 30),
                new Funcionario(3, "Ana Maria", "3333-3333", 22),
                new Funcionario(4, "Fabiana Maria Pereira", null, 55),
                new Funcionario(5, "Fabiana Maria Pereira", null, 55),
                new Funcionario(6, "Alberto Roberto", "4444-4444", 70)
        ));

//        //Lista por algum parâmetro (Funcionario::xxxxx)
//        funcionarioList.stream()
//                .sorted(Comparator.comparing(Funcionario::getNome))
//                .forEach(System.out::println);
//
//        //Lista por nome invertido
//        funcionarioList.stream()
//                .sorted(Comparator.comparing(Funcionario::getNome).reversed())
//                .forEach(System.out::println);

        //Lista por nome com limite
        funcionarioList.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .limit(2)
                .forEach(System.out::println);
    }
}

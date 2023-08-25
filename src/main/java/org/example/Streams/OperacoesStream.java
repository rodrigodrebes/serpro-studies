package org.example.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OperacoesStream {
    public static void main(String[] args) {

        List<Funcionario> funcionarioList = new ArrayList<>(Arrays.asList(
                new Funcionario(1, "José da Silva", "1111-11111", 25),
                new Funcionario(2, "Maria dos santos", "2222-2222", 30),
                new Funcionario(3, "Ana Maria", "3333-3333", 22),
                new Funcionario(4, "Fabiana Maria Pereira", null, 55),
                new Funcionario(5, "Fabiana Maria Pereira", null, 55),
                new Funcionario(6, "Alberto Roberto", "4444-4444", 70),
                new Funcionario(7,"Roberto Josias","8888-8888", 65)
        ));

        // média de idade
        var mediaIdade = funcionarioList.stream()
                .mapToDouble(Funcionario::getIdade)
                .average();
        System.out.println(mediaIdade.getAsDouble());

        //mais velho

        var maisVelho = funcionarioList.stream()
                        .max(Comparator
                                .comparing(Funcionario::getIdade)).get();

        System.out.println("Funcionario mais velho: " + maisVelho);

        // filtros
        funcionarioList.stream()
                .filter(funcionario -> funcionario.getIdade()>50)
                .sorted(Comparator.comparing(Funcionario::getIdade))
                .forEach(System.out::println);




    }
}

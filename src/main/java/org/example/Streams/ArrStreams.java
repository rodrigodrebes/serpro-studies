package org.example.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrStreams {
    public static void main(String[] args) {

        // int
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x->x*x)
                .average()
                .ifPresent(System.out::println);


        // string
        List<String> pessoas = new ArrayList<>(Arrays.asList(
                "Al", "Sandro", "Breno", "Rodrigo", "Thiago", "Eduardo"
        ));

        pessoas.stream()
                .map(String::toLowerCase)
                .filter(pessoa -> pessoa.startsWith("e"))
                .forEach(System.out::println);
    }
}

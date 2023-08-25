package org.example.Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStreams {
    public static void main(String[] args) {

        // sorted, findfirst, ifpresent
        Stream.of("Ana","Roberto","Vicente")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);


        // filter startsWith
        String [] nomes = {"Al", "Francisco", "Lucas", "Pedro", "Sandro"};
        Arrays.stream(nomes)
                .filter(nome -> nome.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }
}

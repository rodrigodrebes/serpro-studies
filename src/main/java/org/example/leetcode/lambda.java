package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class lambda {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

// Filtrar números ímpares e dobrar o valor, usando lambdas + streams
        List<Integer> doubledOdds = numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(doubledOdds); // [6, 2, 10, 2, 10, 18, 10, 6, 10]

// Fazendo uma cópia da lista original
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        // Ordenando a cópia em ordem decrescente
        sortedNumbers.sort(Comparator.reverseOrder());

        int a = 10;
        int b = 1;
        int d = 0;

        // x > y ? se sim, V : senao, F
        d = a > b ? 1: 2;
        System.out.println(d);
    }


}

package org.example.leetcode;

public class VowelCount {
    public static void main(String[] args) {
        String input = "Hello, how are you?";
        int vowelCount = 0;

        String lowerInput = input.toLowerCase(); // Converter para minúsculas para facilitar a comparação
        for (int i = 0; i < lowerInput.length(); i++) {
            char ch = lowerInput.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }

        System.out.println("Número de vogais na string: " + vowelCount);
    }
}
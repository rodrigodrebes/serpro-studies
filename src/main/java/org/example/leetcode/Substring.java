package org.example.leetcode;

public class Substring {
    public static void main(String[] args) {
        String input = "Hello, World!";

        if (input.length() >= 3) {
            String substring = input.substring(0, 3);
            System.out.println("As primeiras três letras são: " + substring);
        } else {
            System.out.println("A string é muito curta para extrair as primeiras três letras.");
        }
    }
}
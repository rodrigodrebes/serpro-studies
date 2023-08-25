package org.example.leetcode;

public class WordCount {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence.";
        String[] words = sentence.split(" ");
        int wordCount = words.length;

        System.out.println("Número de palavras na frase: " + wordCount);
    }
}

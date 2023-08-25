package org.example.leetcode;

public class palindrome {
    public static boolean palin(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    public static void main(String[] args) {
        System.out.println(palin("ola"));
    }
}

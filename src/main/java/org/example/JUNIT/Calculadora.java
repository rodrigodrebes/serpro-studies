package org.example.JUNIT;

public class Calculadora {

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double multiplica(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if(b ==0){
            throw new ArithmeticException("Não pode dividir por zero");
        }else{
            return (a/b);
        }
    }
}


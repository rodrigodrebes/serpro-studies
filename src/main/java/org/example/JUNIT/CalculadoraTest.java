package org.example.JUNIT;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void deveRetornarASomaDosItens(){
        double resultado  = Calculadora.soma(10,5);
        Assert.assertEquals(15,resultado,0.001);
    }

    @Test
    public void deveRetornarMultiplicacao(){
        double resultado = Calculadora.multiplica(1,2);
        Assert.assertEquals(2,resultado,0.001);
    }

    @Test
    public void deveRetornarExcecaoAoDividirPorZero(){
        var erro = Assert.assertThrows(ArithmeticException.class, () -> Calculadora.divide(10,0));
        Assert.assertEquals("Não pode dividir por zero", erro.getMessage());
    }
}

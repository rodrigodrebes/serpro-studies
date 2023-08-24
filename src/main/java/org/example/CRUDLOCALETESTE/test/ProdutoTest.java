package org.example.CRUDLOCALETESTE.test;

import org.example.CRUDLOCALETESTE.entidades.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoTest {

    private Produto produtoTeste;

    @Before
    public void criaProduto(){
        produtoTeste = new Produto("Computador", "ASUS", 3, 3700.00);
    }

    @Test
    public void deveRetornarCalculoDeQuantidadeVezesOPreco(){
        double resultado = produtoTeste.calculaValorTotal();
        Assert.assertEquals(12100.00, resultado,0.01);
    }
}

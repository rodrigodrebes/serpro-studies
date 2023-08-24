package org.example.OOeTESTE.test;


import org.example.OOeTESTE.entidades.ContaBancaria;
import org.example.OOeTESTE.entidades.TIPOCONTA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ContaBancariaTest {

    private ContaBancaria contaTeste;

    @Before
    public void inicializarContaCorrente(){
        contaTeste = new ContaBancaria();
        contaTeste.setNomeCliente("Rodrigo");
        contaTeste.setNumConta("855");
        contaTeste.setSaldo(5000);
        contaTeste.setTipoconta(TIPOCONTA.CORRENTE);
    }

    @Test
    public void naoDeveSacarSeSaldoForInferiorAoValor(){
        boolean saqueRealizado = contaTeste.sacar(contaTeste, 6000);
        Assert.assertFalse(saqueRealizado);
    }

    @Test
    public void deveSacarSeSaldoForSuperiorAoValor(){
        boolean saqueEfetivado = contaTeste.sacar(contaTeste, 5000);
        Assert.assertTrue(saqueEfetivado);
    }

    @Test
    public void naoDeveAceitarDepositoComValorNulo(){
        Assert.assertThrows(IllegalArgumentException.class, ()->{contaTeste.depositar(-100);});
    }


}
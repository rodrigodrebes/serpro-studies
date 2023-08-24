package org.example.OOeTESTE.test;

import org.example.OOeTESTE.entidades.ContaEspecial;
import org.example.OOeTESTE.entidades.ContaPoupanca;
import org.example.OOeTESTE.entidades.TIPOCONTA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaPoupancaTest {

    private ContaPoupanca contaPoupancaTest;

    @Before
    public void inicializarConta(){

        contaPoupancaTest = new ContaPoupanca("Lucas", "855",4500, TIPOCONTA.POUPANCA);
 contaPoupancaTest.setTaxaDeRendimento(0.15);

    }


    @Test
    public void deveSacarSeSaldoMaiorQueValor(){
        boolean saque = contaPoupancaTest.sacar(contaPoupancaTest,3500);
        Assert.assertTrue(saque);
    }

    @Test
    public void deveRetornarNovoSaldoCalculadoComTaxaDeRendimento(){
        boolean saqueNovo = contaPoupancaTest.calculaNovoSaldo();
        Assert.assertTrue(saqueNovo);
    }

    @Test
    public void naoDeveRetornarNovoSaldoSeSaldoAtualForMenorOuIgualAZero(){
        contaPoupancaTest.setSaldo(0);
        boolean saqueNovo = contaPoupancaTest.calculaNovoSaldo();
        Assert.assertFalse(saqueNovo);
    }

}

package org.example.OOeTESTE.test;

import org.example.OOeTESTE.entidades.ContaEspecial;
import org.example.OOeTESTE.entidades.TIPOCONTA;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaEspecialTest {

    private ContaEspecial contaEspecialTest;

    @Before
    public void inicializarConta(){
        contaEspecialTest = new ContaEspecial("Rodrigo", "855",4500, TIPOCONTA.CONTA_ESPECIAL);
    }

    @Test
    public void naoDeveSacarSeSaldoMaisLimiteForemIguaisOuMaioresQueValor(){
        contaEspecialTest.setLimite(500);
        boolean saqueRealizado = contaEspecialTest.sacar(contaEspecialTest, 5500);
        Assert.assertFalse(saqueRealizado);
    }

    @Test
    public void deveSacarSeSaldoMaisLimiteForemIguaisOuMaioresQueValor(){
        contaEspecialTest.setLimite(500);
        boolean saqueRealizado = contaEspecialTest.sacar(contaEspecialTest, 5000);
        Assert.assertTrue(saqueRealizado);
    }

    @Test
    public void testeNomeClienteDeveRetornarRodrigo() {
        String esperado = "Rodrigo";
        String real = contaEspecialTest.getNomeCliente();
        Assert.assertEquals(esperado, real);
    }
}

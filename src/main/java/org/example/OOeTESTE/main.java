package org.example.OOeTESTE;

import org.example.OOeTESTE.entidades.ContaBancaria;
import org.example.OOeTESTE.entidades.ContaEspecial;
import org.example.OOeTESTE.entidades.ContaPoupanca;
import org.example.OOeTESTE.entidades.TIPOCONTA;

public class main {
    public static void main(String[] args) {

        System.out.println("CONTA CORRENTE");
        ContaBancaria conta = new ContaBancaria("Rodrigo", "455", 5000, TIPOCONTA.CORRENTE);
        System.out.println(conta);
        conta.depositar(1000);
        System.out.println(conta.getSaldo());

        System.out.println("\nCONTA POUPANÇA");
        ContaPoupanca conta2 = new ContaPoupanca("Vitoria","477", 4000, TIPOCONTA.POUPANCA);

        conta2.setTaxaDeRendimento(0.25);
        System.out.println(conta2.getTaxaDeRendimento());
        conta2.sacar(conta2, 3000);
        System.out.println(conta2);
        conta2.depositar(2000);
        System.out.println(conta2);
        System.out.println(conta2.calculaNovoSaldo());


        System.out.println("\nCONTA ESPECIAL");
        ContaEspecial conta3 = new ContaEspecial("Lucas", "855", 3000, TIPOCONTA.CONTA_ESPECIAL);

        System.out.println(conta3.getSaldo());
        conta3.depositar(2000);
        System.out.println(conta3.getSaldo());
        conta3.setNumConta("655");
        System.out.println(conta3.getNumConta());
        conta3.setLimite(500);
        conta3.sacar(conta3, 5600);

    }
}

package org.example.OOeTESTE.entidades;

public class ContaPoupanca extends ContaBancaria{

    private double taxaDeRendimento;

    public ContaPoupanca(String nomeCliente, String numConta, double saldo, TIPOCONTA tipoconta) {
        super(nomeCliente, numConta, saldo, tipoconta);
    }

    public double getTaxaDeRendimento(){
        return taxaDeRendimento;
    }

    public void setTaxaDeRendimento(double taxaDeRendimento) {
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public boolean calculaNovoSaldo() {
        if(this.getSaldo() > 0) {
            double novoSaldo = this.getSaldo() + (this.getSaldo() * taxaDeRendimento);
            this.setSaldo(novoSaldo);
            return true;
        }return false;
    }
}

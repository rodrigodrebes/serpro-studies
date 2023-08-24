package org.example.OOeTESTE.entidades;

public class ContaBancaria {

    private String nomeCliente;
    private String numConta;
    private double saldo;

    private TIPOCONTA tipoconta;

    public ContaBancaria(){

    }

    public ContaBancaria(String nomeCliente, String numConta, TIPOCONTA tipoconta){
        this.nomeCliente=nomeCliente;
        this.numConta=numConta;
        this.tipoconta=tipoconta;
    }
    public ContaBancaria(String nomeCliente, String numConta, double saldo, TIPOCONTA tipoconta) {
        this.nomeCliente = nomeCliente;
        this.numConta = numConta;
        this.saldo = saldo;
        this.tipoconta=tipoconta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TIPOCONTA getTipoconta() {
        return tipoconta;
    }

    public void setTipoconta(TIPOCONTA tipoconta) {
        this.tipoconta = tipoconta;
    }

    public String toString(){
        return "Nome Cliente: "+nomeCliente+"\nNúmero conta: "+numConta+"\nTipo de Conta: "+tipoconta+"\nSaldo: "+saldo;
    }

    public void depositar(double valor){
        if(valor<0){
            throw new IllegalArgumentException("Não é possível depósito de valores nulos!");
        }
        saldo+=valor;
    }
    public boolean sacar(ContaBancaria conta, double valor){
        if(valor <= saldo){
            saldo-=valor;
            return true;
        }
        System.out.println("Saldo insuficiente para realizar o saque!");
        return false;
    }
}

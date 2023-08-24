package org.example.OOeTESTE.entidades;

public class ContaEspecial extends ContaBancaria {

    private double limite;

    public ContaEspecial(String nomeCliente, String numConta, double saldo, TIPOCONTA tipoconta) {
        super(nomeCliente, numConta, saldo, tipoconta);
    }


    public void setLimite(double limite) {
        this.limite = limite;
    }
    @Override
    public boolean sacar(ContaBancaria conta, double valor){
        double saldoComLimite = this.getSaldo()+limite;
        if(valor <= saldoComLimite){
            this.setSaldo(this.getSaldo()-valor);
            System.out.println("Saque realizado com sucesso! seu saldo é: "+this.getSaldo());
            return true;
        }
        System.out.println("Valor maior que Saldo + Limite!");
        return false;
    }
}

package org.example.OOeTESTE.entidades;

public enum TIPOCONTA {
    CORRENTE(1),
    POUPANCA(2),
    CONTA_ESPECIAL(3);

    private int valor;
    TIPOCONTA (int valor){
        this.valor=valor;
    }
    public int getValor() {
        return valor;
    }



}

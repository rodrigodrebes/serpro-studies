package org.example.CRUDLOCAL2;

public class Cliente {

    private static int nextId = 1;
    private int id;
    private String nome;
    private double salario;


    public Cliente(){
        this.id=nextId++;
    }

    public Cliente(String nome, double salario) {
        this();
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "\nId=" + id +
                "\nNome='" + nome +
                "\nSalario=" + salario;
    }
}

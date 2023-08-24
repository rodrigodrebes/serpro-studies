package org.example.CRUDSqlite2;

public class Funcionario {

    private int id;

    private String nome;

    private String departamento;

    private double salario;

    public Funcionario(){

    }

    public Funcionario(String nome, String departamento, double salario){
        this.nome=nome;
        this.departamento=departamento;
        this.salario=salario;
    }
    public Funcionario(int id, String nome, String departamento, double salario) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "ID do Funcionário: "+id+"\nNome: "+nome+"\nDepartamento: "+departamento+"\nSalário: "+salario;
    }
}

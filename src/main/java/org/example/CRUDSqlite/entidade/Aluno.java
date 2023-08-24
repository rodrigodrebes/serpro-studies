package org.example.CRUDSqlite.entidade;

public class Aluno {

    private int id;
    private String nome;
    private String email;
    private double salario;

    public Aluno() {
    }


    public Aluno(String nome, String email, double salario){
        this.nome=nome;
        this.email=email;
        this.salario=salario;
    }

    public Aluno(int id, String nome, String email, double salario){
        this.id=id;
        this.nome=nome;
        this.email=email;
        this.salario=salario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String toString(){
        return "ID: "+id+"\nNome: "+nome+"\nEmail: "+email+"\nSalario: "+salario;
    }
}

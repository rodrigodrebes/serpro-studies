package org.example.CRUDPostGres2;

public class Funcionario {

    private Integer id;

    private String nome;

    private String telefone;

    private String departamento;

    public Funcionario(){

    }
    public Funcionario( String nome, String telefone, String departamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.departamento = departamento;
    }

    public Funcionario(Integer id, String nome, String telefone, String departamento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String toString(){
        return "ID: "+id+"\nNome: "+nome+"\nTelefone: "+telefone+"\nDepartamento: "+departamento;
    }
}

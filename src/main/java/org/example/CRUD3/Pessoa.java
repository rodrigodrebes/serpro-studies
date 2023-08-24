package org.example.CRUD3;

public class Pessoa {
    private Long id;
    private String nome;
    private int idade;


    public Pessoa(){
    }

    public Pessoa(String nome, int idade){
        this.nome=nome;
        this.idade=idade;
    }
    public Pessoa(Long id, String nome, int idade){
        this.id=id;
        this.nome=nome;
        this.idade=idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setIdade(int idade){
        this.idade=idade;
    }

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String toString(){
        return "ID: " + id +"\nNome " + nome + "\nIdade: "+ idade;
    }
}

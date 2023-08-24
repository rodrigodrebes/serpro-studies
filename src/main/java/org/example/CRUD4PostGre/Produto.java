package org.example.CRUD4PostGre;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;

    public Produto(){}
    public Produto(String nome, int quantidade){
        this.nome=nome;
        this.quantidade=quantidade;
    }
    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId(){
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return "Nome: " + nome + "\nQuantidade: " + quantidade;
    }
}

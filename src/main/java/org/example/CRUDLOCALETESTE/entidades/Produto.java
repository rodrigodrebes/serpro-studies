package org.example.CRUDLOCALETESTE.entidades;

public class Produto {

    private static int nextId = 1;
    private int id;
    private String nome;
    private String marca;
    private int quantidade;
    private double preco;

    public Produto(){
        this.id = nextId++;
    }

    public Produto(String nome, String marca, int quantidade, double preco){
        this();
        this.nome=nome;
        this.marca=marca;
        this.quantidade=quantidade;
        this.preco=preco;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "ID do Produto: "+id+"\nNome: "+nome+"\nMarca: "+marca+"\nQuantidade: "+quantidade;
    }

    public double calculaValorTotal(){
        double valorTotal = quantidade*preco;
        return valorTotal;
    }
}

package org.example.CRUD2;

import java.util.List;

public class Livro {
    private String nome;
    private String autor;
    private Double preco;

    public Livro(){
    }
    public Livro(String nome, String autor, Double preco){
        this.nome=nome;
        this.autor=autor;
        this.preco=preco;
    }

    public String getNome(){
        return this.nome;
    }

    public String getAutor(){
        return this.autor;
    }

    public Double getPreco(){
        return this.preco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setPreco(Double preco){
        this.preco = preco;
    }

    public String toString(){
        return "Livro: "+nome+ "\nAutor: "+autor+"\nPreço: "+preco;
    }

    public void add(List<Livro> listaDeLivros) {
    }
}

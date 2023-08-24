package org.example.CRUDLOCALETESTE.db;

import org.example.CRUDLOCALETESTE.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    List<Produto> listaDeProdutos = new ArrayList<>();
    public List<Produto> getAll(){
        listaDeProdutos.forEach(System.out::println);
        return listaDeProdutos;
    }

    public Produto findById(int id) {
        for (Produto p : listaDeProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void addProduto(Produto produto){
        listaDeProdutos.add(produto);
    }

    public void deleteProduto(int id){
        listaDeProdutos.removeIf(produto -> produto.getId() == id);
    }

    public void updateProduto(int id, String nome, String marca, int quantidade, double preco){
        for (Produto p : listaDeProdutos){
            if(p.getId() == id){
                p.setNome(nome);
                p.setMarca(marca);
                p.setQuantidade(quantidade);
                p.setPreco(preco);
                break;
            }
        }
    }

}

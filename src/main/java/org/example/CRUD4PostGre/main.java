package org.example.CRUD4PostGre;


import org.example.CRUD3.Pessoa;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        DBFunctions.createTables();
        ProdutoDAO produtoDAO = new ProdutoDAO();

//        // adiciona produto
//
//        Produto produto = new Produto("PC", 5);
//        produtoDAO.insertProduto(produto);

        //retorna todos produtos
        List<Produto> produtos = produtoDAO.getProdutos();
        for (Produto produto : produtos){
            System.out.println(produto);
        }
//
//        //deleta um produto pelo ID
//        produtoDAO.deleteProduto(1);
//

//        // edita um produto
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Digite o ID do Produto que deseja atualizar:");
//        int id = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Digite o nome novo do Produto: ");
//        String nome = sc.nextLine();
//        System.out.println("Digite a nova quantidade do Produto:");
//        int quantidade = sc.nextInt();
//        sc.nextLine();
//        Produto produtoAtt = new Produto(id, nome, quantidade);
//        produtoDAO.editProduto(produtoAtt);

//        //edita direto
//        Produto novoProduto = new Produto(3,"Mesa",60);
//        produtoDAO.editProduto(novoProduto);
    }
}
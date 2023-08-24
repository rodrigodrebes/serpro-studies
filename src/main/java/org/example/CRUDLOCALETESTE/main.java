package org.example.CRUDLOCALETESTE;

import org.example.CRUDLOCALETESTE.db.ProdutoDAO;
import org.example.CRUDLOCALETESTE.entidades.Produto;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        ProdutoDAO produtoDAO = new ProdutoDAO();

        Scanner sc = new Scanner(System.in);

        Produto p = new Produto("PC", "ASUS", 5, 3800);
        Produto p2 = new Produto("Mesa", "lala", 5, 780);

        produtoDAO.addProduto(p);
        produtoDAO.addProduto(p2);
        produtoDAO.getAll();


    }
}

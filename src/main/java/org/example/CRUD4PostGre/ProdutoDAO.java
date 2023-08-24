package org.example.CRUD4PostGre;

import org.example.CRUD3.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgrecrud";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "senha";

    public void insertProduto(Produto produto){

        String sql = "INSERT INTO produto (nome, quantidade) VALUES (?,?)";

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Produto> getProdutos(){
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try(Connection conn = DBFunctions.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public void editProduto(Produto produto){

        String sql = "UPDATE produto SET nome = ?, quantidade = ? where id = ?";

                try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)){

                    pstmt.setString(1, produto.getNome());
                    pstmt.setInt(2, produto.getQuantidade());
                    pstmt.setLong(3, produto.getId());
                    int updatedRows = pstmt.executeUpdate();

                    if (updatedRows > 0) {
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto com ID " + produto.getId() + " não encontrado.");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }

    }

    public void deleteProduto(int id){

        String sql = "DELETE from produto WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if(affectedRows > 0) {
                System.out.println(String.format("Produto de id %d deletado com sucesso!", id));
            } else {
                System.out.println(String.format("Produto de id %d não encontrado!", id));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}

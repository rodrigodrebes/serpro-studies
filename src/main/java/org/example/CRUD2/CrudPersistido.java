package org.example.CRUD2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudPersistido {
    public static void main(String[] args) throws SQLException {

        List<Livro> listaDeLivros2 = new ArrayList<>();

        listaDeLivros2.add(new Livro("Morangos Mofados", "Caio F de Abreu", 18.9));

//        // insere dados no BD
//
        Connection conn = DriverManager.getConnection("jdbc:sqlite:livros.db");
//
//        try (conn) {
//            String sql = "CREATE TABLE IF NOT EXISTS livros (nome TEXT, autor TEXT, preco REAL)";
//
//            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.executeUpdate();
//            }
//
//            for (Livro livro : listaDeLivros2) {
//                sql = "INSERT INTO livros (nome, autor, preco) VALUES (?,?,?)";
//
//                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                    pstmt.setString(1, livro.getNome());
//                    pstmt.setString(2, livro.getAutor());
//                    pstmt.setDouble(3, livro.getPreco());
//                    pstmt.executeUpdate();
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }


        // recupera dados do SQLITE
        try (conn) {
            String sql = "SELECT * FROM livros";

            try (Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)) {

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getString("nome") + "\t" +
                                    rs.getString("autor")+ "\t" +
                            rs.getDouble("preco"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

package org.example.CRUD3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    public List<Pessoa> findPessoas(){
        List<Pessoa> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM pessoacrud";

        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoacrud.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getLong("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoas.add(pessoa);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public void insert(Pessoa pessoa){

        String sql = "INSERT INTO pessoacrud (nome, idade) VALUES (?,?)";

        try(
                Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoacrud.db");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Pessoa pessoa){

        if (pessoa.getId() == null) {
            System.out.println("Não é possível atualizar uma pessoa sem um ID válido.");
            return;
        }

        String sql = "UPDATE pessoacrud SET nome = ?, idade = ? WHERE id = ?";

        try(
                Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoacrud.db");
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getIdade());
            pstmt.setLong(3, pessoa.getId());
            int updatedRows = pstmt.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Pessoa atualizada com sucesso!");
            } else {
                System.out.println("Pessoa com ID " + pessoa.getId() + " não encontrada.");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void delete(Long id){

        String sql = "DELETE FROM pessoacrud WHERE id = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoacrud.db");
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            System.out.println("Pessoa deletada com sucesso!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}

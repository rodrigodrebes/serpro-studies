package org.example.CRUDSqlite.dao;

import org.example.CRUD3.Pessoa;
import org.example.CRUDSqlite.entidade.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void insertAluno(Aluno aluno){
        String sql = "INSERT INTO alunocrud (nome, email, salario) VALUES (?,?,?)";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:alunocrud.db");
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getEmail());
            pstmt.setDouble(3, aluno.getSalario());

            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<Aluno> getAll(){
        List<Aluno> listaDeAlunos = new ArrayList<>();

        String sql = "SELECT * FROM alunocrud";

        try{

            Connection conn = DriverManager.getConnection("jdbc:sqlite:alunocrud.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setSalario(rs.getDouble("salario"));
                listaDeAlunos.add(aluno);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }


        return listaDeAlunos;
    }

    public void delete(int id){

        String sql = "DELETE FROM alunocrud WHERE id = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:alunocrud.db");
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if(affectedRows > 0) {
                System.out.println(String.format("Aluno de id %d deletado com sucesso!", id));
            } else {
                System.out.println(String.format("Aluno de id %d não encontrado!", id));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void edit(Aluno aluno){

        if (aluno.getId() == 0) {
            System.out.println("Não é possível atualizar uma pessoa sem um ID válido.");
            return;
        }
        String sql = "UPDATE alunocrud SET nome = ?, email = ?, salario = ? WHERE id = ?";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:alunocrud.db");
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setDouble(3,aluno.getSalario());
            stmt.setInt(4, aluno.getId());

            int updatedRows = stmt.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno com ID " + aluno.getId() + " não encontrado.");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

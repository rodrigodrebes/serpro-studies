package org.example.CRUDSqlite2;

import java.sql.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public List<Funcionario> getAll() {
        List<Funcionario> listafuncionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:funcionariocrud.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionaro = new Funcionario();
                funcionaro.setId(rs.getInt("id"));
                funcionaro.setNome(rs.getString("nome"));
                funcionaro.setDepartamento(rs.getString("departamento"));
                funcionaro.setSalario(rs.getDouble("salario"));
                listafuncionarios.add(funcionaro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listafuncionarios;
    }

    public void insertFuncionario(Funcionario f) {

        String sql = "INSERT INTO funcionario (nome, departamento, salario) VALUES (?,?,?)";

        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getDepartamento());
            pstmt.setDouble(3, f.getSalario());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeFuncionario(int id) {

        String sql = "DELETE FROM funcionario WHERE id = ?";

        try (Connection conn = DbFunctions.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println(String.format("Funcionário de id %d deletado com sucesso!", id));
            } else {
                System.out.println(String.format("Funcionário de id %d não encontrado!", id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editFuncionario(Funcionario f) {

        String sql = "UPDATE funcionario SET nome = ?, departamento = ?, salario = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:funcionariocrud.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getDepartamento());
            pstmt.setDouble(3, f.getSalario());
            pstmt.setInt(4, f.getId());

            int updatedRows = pstmt.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Funcionário atualizado com sucesso!");
            } else {
                System.out.println("Funcionário com ID " + f.getId() + " não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Funcionario searchById(int id) {

        String sql = "SELECT * FROM funcionario WHERE id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:funcionariocrud.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id2 = rs.getInt("id");
                String nome = rs.getString("nome");
                String depto = rs.getString("departamento");
                double salario = rs.getDouble("salario");

                Funcionario f = new Funcionario(id2, nome, depto, salario);
                System.out.println(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}


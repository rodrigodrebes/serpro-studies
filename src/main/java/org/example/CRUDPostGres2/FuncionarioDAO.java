package org.example.CRUDPostGres2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {
    public void createFuncionario(Funcionario f){

        String sql = "INSERT INTO funcionario (nome, telefone, departamento) VALUES (?,?,?)";

        try(Connection conn = DbFunctions.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getTelefone());
            pstmt.setString(3, f.getDepartamento());

            pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Funcionario> getAll(){
        List<Funcionario> funcionarioList = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try(Connection conn = DbFunctions.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setDepartamento(rs.getString("departamento"));

                funcionarioList.add(f);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return funcionarioList;
    }

    public void removeFuncionarioById(Integer id){

        String sql = "DELETE FROM funcionario WHERE id = ?";

        try(Connection conn = DbFunctions.getConn();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected>0){
                System.out.println(String.format("Usuário de id %d deletado com sucesso!", id));
            }else{
                System.out.println(String.format("Usuário de id %d não encontrado", id));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void attFuncionario(Funcionario f){

        String sql = "UPDATE funcionario SET nome = ?, telefone = ?, departamento = ? WHERE id = ?";

        try(Connection conn = DbFunctions.getConn();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,f.getNome());
            pstmt.setString(2, f.getTelefone());
            pstmt.setString(3, f.getDepartamento());
            pstmt.setInt(4, f.getId());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected>0){
                System.out.println(String.format("Usuário de id %d atualizado com sucesso!", f.getId()));
            }else{
                System.out.println(String.format("Usuário não encontrado!"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Funcionario getById(Integer id){
        String sql = "SELECT FROM funcionario WHERE id = ?";

        try(Connection conn = DbFunctions.getConn();
        Statement pstmt = conn.createStatement()){

            for(Funcionario f : getAll()){
                if (f.getId() == id){
                    System.out.println(f);
                    return f;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(String.format("Usuário de id %d não encontrado!", id));
        return null;
    }
}

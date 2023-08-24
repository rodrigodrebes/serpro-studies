package org.example.CRUD7POSTGRESETESTES.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactsDAO {

    public void addContact(Contacts contact){
        String sql = "INSERT INTO contacts (name, email, phone) VALUES (?,?,?)";

        try(Connection conn = ConnectionDB.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstmt.setString(1,contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3,contact.getPhone());

            pstmt.executeUpdate();

            // Recupera o ID gerado pelo banco
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contact.setId(generatedKeys.getInt(1));
                }
            }

    }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Contacts> getContactsList(){
        List<Contacts> contactsList = new ArrayList<>();

        String sql = "SELECT * FROM contacts";

        try(Connection conn = ConnectionDB.getConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Contacts contato = new Contacts();
                contato.setId(rs.getInt("id"));
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setPhone(rs.getString("phone"));

                contactsList.add(contato);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return contactsList;
    }

    public Contacts getContactById(int id){
        String sql = "SELECT * FROM contacts WHERE id = ?";

        try(Connection conn = ConnectionDB.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Contacts contato = new Contacts();
                contato.setId(rs.getInt("id"));
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setPhone(rs.getString("phone"));
                return contato;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void removeContact(int id){

        String sql = "DELETE FROM contacts WHERE id = ?";

        try(Connection conn = ConnectionDB.getConexao();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if(affectedRows>0){
                System.out.println(String.format("Usuário de %d excluído com sucesso!", id));
            }else{
                System.out.println(String.format("Usuário de %d não encontrado.", id));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateContact(Contacts contact){
        String sql = "UPDATE contacts SET name =?, email =?, phone=? WHERE id = ?";

        try(Connection conn = ConnectionDB.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3,contact.getPhone());
            pstmt.setInt(4, contact.getId());

            int affectedRows = pstmt.executeUpdate();

            if(affectedRows>0){
                System.out.println(String.format("Usuário de %d editado com sucesso!", contact.getId()));
            }else{
                System.out.println(String.format("Usuário de %d não encontrado.", contact.getId()));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Contacts> concactsListByName(){
        List<Contacts> listaPorNome = getContactsList().stream()
                .sorted(Comparator.comparing(Contacts::getName))
                .collect(Collectors.toList());
        return listaPorNome;
    }
}

package org.example.CRUD7POSTGRESETESTES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactsDAO {

    public void addContact(Contacts contact){
        String sql = "INSERT INTO contacts (name, email, phone) VALUES (?,?,?)";

        try(Connection conn = ConnectionDB.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3,contact.getPhone());

            pstmt.executeUpdate();

    }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Contacts> contactsList(){
        List<Contacts> contactsList = new ArrayList<>();

        return contactsList;
    }

    public void removeContact(int id){

    }

    public void updateContact(Contacts contact){

    }

    public List<Contacts> concactsListByName(){
        List<Contacts> listaPorNome = contactsList().stream()
                .sorted(Comparator.comparing(Contacts::getName))
                .collect(Collectors.toList());
        return listaPorNome;
    }
}

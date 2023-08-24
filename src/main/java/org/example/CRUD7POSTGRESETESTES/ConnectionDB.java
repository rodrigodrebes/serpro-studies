package org.example.CRUD7POSTGRESETESTES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

    private final static String URL ="jdbc:postgresql://localhost:5432/crudpostgres";
    private final static String USER="postgres";
    private final static String PASSWORD="senha";

    public void createTables(){
        String contacts = "CREATE TABLE IF NOT EXISTS contacts (id SERIAL PRIMARY KEY, name VARCHAR(255), email VARCHAR(150), phone VARCHAR(50))";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement()){

            stmt.execute(contacts);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConexao(){
        Connection conn=null;
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        }catch (SQLException e){
            e.printStackTrace();
        }return conn;
    }
}

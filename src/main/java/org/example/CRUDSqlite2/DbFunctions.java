package org.example.CRUDSqlite2;

import java.sql.*;

public class DbFunctions {

    public static Connection getConnection() {
        Connection conn = null;
        try {
           conn = DriverManager.getConnection("jdbc:sqlite:funcionariocrud.db");

        } catch (SQLException e) {
            e.printStackTrace();
        } return conn;
    }


    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS funcionario (id INTEGER PRIMARY KEY AUTOINCREMENT , nome TEXT, departamento TEXT, salario DOUBLE)";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:funcionariocrud.db");
        Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

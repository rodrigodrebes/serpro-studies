package org.example.CRUD3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

//    public static void createTable() throws SQLException {
//
//        // jeito normal:
//        try {
//            String sql = "CREATE TABLE IF NOT EXISTS pessoaCrud (nome TEXT, idade INTEGER)";
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoacrud.db");
//            Statement stmt = conn.createStatement();
//            stmt.execute(sql);
//            System.out.println("Tabela criada com sucesso!");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

        // jeito com try-with-resources
        public static void createTable() throws SQLException {
            String sql = "CREATE TABLE IF NOT EXISTS pessoacrud (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER)";

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:pessoacrud.db");
                 Statement stmt = conn.createStatement()) {

                stmt.execute(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
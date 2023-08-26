package org.example.CRUDPostGres2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions {

    private static String URL = "jdbc:postgresql://localhost:5432/lastcrud";
    private static String USER = "postgres";
    private static String PASSWORD = "senha";

    public static Connection getConn(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS funcionario (id SERIAL PRIMARY KEY, nome VARCHAR(255), telefone VARCHAR(60), departamento VARCHAR(40))";

        try(Connection conn = getConn();
        Statement stmt = conn.createStatement()){
            stmt.executeQuery(sql);
            System.out.println("Tabela criada com sucesso!");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

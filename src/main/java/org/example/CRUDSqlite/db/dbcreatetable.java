package org.example.CRUDSqlite.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbcreatetable {

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS alunocrud (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, email TEXT, salario DOUBLE)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:alunocrud.db");
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

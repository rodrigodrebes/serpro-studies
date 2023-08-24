package org.example.CRUD4PostGre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFunctions {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgrecrud";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "senha";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexão feita com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

        public static void createTables() {
            String sqlProduto = "CREATE TABLE IF NOT EXISTS produto (id SERIAL PRIMARY KEY, nome VARCHAR(255), quantidade INTEGER)";
            String sqlFornecedor = "CREATE TABLE IF NOT EXISTS fornecedor (id SERIAL PRIMARY KEY, nome VARCHAR(255), cnpj VARCHAR(14))";
            String sqlFornecedor_produto = "CREATE TABLE IF NOT EXISTS fornecedor_produto (\n" +
                    "    fornecedor_id INTEGER REFERENCES fornecedor(id),\n" +
                    "    produto_id INTEGER REFERENCES produto(id),\n" +
                    "    PRIMARY KEY (fornecedor_id, produto_id)\n" +
                    ");";

            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                     Statement stmt = conn.createStatement()) {

                    stmt.execute(sqlProduto);
                    stmt.execute(sqlFornecedor);
                    stmt.execute(sqlFornecedor_produto);

                 System.out.println("Tabelas criadas com sucesso!");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


    }



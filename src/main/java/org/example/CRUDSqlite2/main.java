package org.example.CRUDSqlite2;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {

        try {
            DbFunctions.createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

//        Funcionario funcionario = new Funcionario("Mavi", "RH", 3500);

//        funcionarioDAO.insertFuncionario(funcionario);

//        funcionarioDAO.removeFuncionario(3);
        funcionarioDAO.getAll().forEach(System.out::println);
    funcionarioDAO.searchById(1);

    }
}

package org.example.CRUDPostGres2;

public class Main {
    public static void main(String[] args) {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        DbFunctions.createTable();

        Funcionario f = new Funcionario(2,"Thiago", "8888-8888", "Almoxarifado");

//    funcionarioDAO.createFuncionario(f);

     funcionarioDAO.getAll().stream()
             .forEach(System.out::println);

//        funcionarioDAO.removeFuncionarioById(1);
//        funcionarioDAO.attFuncionario(f);
    }
}

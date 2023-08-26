package org.example.CRUDLocal8;

public class Main {
    public static void main(String[] args) {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario f = new Funcionario(1,"Rodrigo", "TI");

        funcionarioDAO.addFuncionario(f);
        System.out.println(funcionarioDAO.getAll());

        funcionarioDAO.findById(1);

    }
}

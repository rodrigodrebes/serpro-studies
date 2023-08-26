package org.example.CRUDLocal8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarListaEmTxt {
    public static void main(String[] args) {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario f = new Funcionario(1,"Rodrigo", "TI");
        Funcionario f2 = new Funcionario(2,"Thiago", "Almoxarifado");
        Funcionario f3 = new Funcionario(3,"Fernanda", "Administração");

        funcionarioDAO.addFuncionario(f);
        funcionarioDAO.addFuncionario(f2);
        funcionarioDAO.addFuncionario(f3);

        String outputpath = "funcionarios.txt";


        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputpath))){

            bw.write("Funcionarios");
            bw.newLine();

            for(Funcionario funcionario : funcionarioDAO.getAll()){
                bw.write("ID: " +funcionario.getId());
                bw.newLine();
                bw.write("NOME: "+funcionario.getNome());
                bw.newLine();
                bw.write("DEPTO: "+funcionario.getDepto());
                bw.newLine();
            }



        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

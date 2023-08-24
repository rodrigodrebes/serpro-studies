package org.example.CRUDSqlite.aplicacao;

import org.example.CRUDSqlite.dao.AlunoDAO;
import org.example.CRUDSqlite.db.dbcreatetable;
import org.example.CRUDSqlite.entidade.Aluno;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        try {
            dbcreatetable.createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Aluno aluno = new Aluno("Emilio", "emilio@gmail.com", 56000);
//        alunoDAO.insertAluno(aluno);
//
       for(Aluno a : alunoDAO.getAll()) {
           System.out.println(a);
       }

//        alunoDAO.delete(2);

//        Aluno aluno = new Aluno(3,"Rodrigo", "o@gm", 955);
//        alunoDAO.edit(aluno);

    }
}

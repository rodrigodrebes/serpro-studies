package org.example.CRUDLocal8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDAO {

    List<Funcionario> listaFuncionario = new ArrayList<>();

    public void addFuncionario(Funcionario f){
        listaFuncionario.add(f);
    }

    public void removeById(Integer id){
        listaFuncionario.removeIf(funcionario -> funcionario.getId() == id);
    }

    public List<Funcionario> getAll(){
      return new ArrayList<>(listaFuncionario);
    }

    public void updateFuncionario(Funcionario f){
        for(Funcionario fun : listaFuncionario){
            if(f.getId() == fun.getId()){
                fun.setNome(f.getNome());
                fun.setDepto(f.getDepto());
            }
            System.out.println("Funcionário de id "+ f.getId()+ " atualizado com sucesso!");
        }
    }

    public void findById(Integer id){
       listaFuncionario.stream()
               .filter(funcionario -> funcionario.getId() == id)
               .forEach(System.out::println);

    }

}

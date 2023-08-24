package org.example.CRUDLOCAL2;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    List<Cliente> listaDeClientes = new ArrayList<>();

    public List<Cliente> getAll(){
        listaDeClientes.forEach(System.out::println);
        return listaDeClientes;
    }

    public Cliente findById(int id){
        for (Cliente c : listaDeClientes){
            if(c.getId() == id){
                return c;
            }
        } return null;
    }

    public void addCliente(Cliente cliente){
        listaDeClientes.add(cliente);
    }

    public void removeClienteById(int id){
        listaDeClientes.removeIf(cliente -> cliente.getId() == id);
    }

    public void updateCliente(int id, String nome, double salario){
        for (Cliente c : listaDeClientes){
            if(c.getId() == id){
                c.setNome(nome);
                c.setSalario(salario);
                break;
            }
        }
    }
}

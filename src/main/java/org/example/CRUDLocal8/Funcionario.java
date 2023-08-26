package org.example.CRUDLocal8;

public class Funcionario {

    private Integer id;
    private String nome;
    private String depto;

    public Funcionario(){

    }
    public Funcionario(String nome, String depto){
        this.nome=nome;
        this.depto=depto;

    }

    public Funcionario(Integer id, String nome, String depto) {
        this.id = id;
        this.nome = nome;
        this.depto = depto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", depto='" + depto + '\'' +
                '}';
    }
}

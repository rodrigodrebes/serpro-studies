package org.example.CRUD5LOCAL;

public class User {

    private static int ID_COUNTER = 0;
    private int id;
    private String name;
    private int age;
    private double salary;

    public User(String name, int age, double salary){
        this.id = ++ID_COUNTER;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString(){
        return "Id: "+id+"\nNome: " + name + "\nIdade: "+ age + "\nSalário: "+salary;
    }
}

package org.example.CRUD7POSTGRESETESTES.Application;

public class Contacts {

    private int id;
    private String name;
    private String email;
    private String phone;

    public Contacts(){
    }

    public Contacts(String name, String email, String phone){
        this.name=name;
        this.email=email;
        this.phone=phone;
    }
    public Contacts(int id, String name, String email, String phone){
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return "ID: "+id+"\nNome: "+name+"\nEmail: "+email+"\nFone: "+phone;
    }
}

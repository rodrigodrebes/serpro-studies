package org.example.JPABasico;

import javax.persistence.*;

@Entity
public class Pessoa {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;

    public Pessoa(){

    }

    public Pessoa(Integer id, String name, String email){
        super();
        this.id=id;
        this.name=name;
        this.email=email;
    }
}

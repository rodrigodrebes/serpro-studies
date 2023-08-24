package org.example.JPABasico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(null,"Ana", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exemplo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();

    }


}

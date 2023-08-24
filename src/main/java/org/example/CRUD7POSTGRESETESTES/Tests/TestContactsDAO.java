package org.example.CRUD7POSTGRESETESTES.Tests;

import org.example.CRUD7POSTGRESETESTES.Application.Contacts;
import org.example.CRUD7POSTGRESETESTES.Application.ContactsDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestContactsDAO {

    private ContactsDAO testContactsDAO;
    private Contacts contact;
    @Before
    public void setUp(){
        testContactsDAO = new ContactsDAO();
        contact = new Contacts("Lucas", "l@gmail.com","5511557999");
    }

    @Test
    public void deveAdicionarContato(){
        int tamanhoAntes = testContactsDAO.getContactsList().size();

        testContactsDAO.addContact(contact);

        int tamanhoDepois = testContactsDAO.getContactsList().size();
        Assert.assertEquals(tamanhoAntes + 1, tamanhoDepois);
    }

    @Test
    public void deveListarTodosContatos(){
        testContactsDAO.addContact(contact);
        Assert.assertFalse(testContactsDAO.getContactsList().isEmpty());
    }

    @Test
    public void deveRemoverContato(){
        testContactsDAO.addContact(contact);
        int tamanhoAntes = testContactsDAO.getContactsList().size();
        testContactsDAO.removeContact(contact.getId());
        int tamanhoDepois = testContactsDAO.getContactsList().size();
        Assert.assertEquals(tamanhoAntes -1, tamanhoDepois);

        }

    @Test
    public void deveAtualizarContato(){
        testContactsDAO.addContact(contact);
        Contacts contatoAtualizado = new Contacts(contact.getId(),"Pedro", "p@gmail.com", "598989");
        testContactsDAO.updateContact(contatoAtualizado);

        Assert.assertEquals("Pedro",contatoAtualizado.getName());
    }
}

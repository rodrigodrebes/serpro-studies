package org.example.CRUD7POSTGRESETESTES;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {

        ConnectionDB cdb = new ConnectionDB();
        cdb.createTables();
        ContactsDAO contactsDAO = new ContactsDAO();

        Contacts contato = new Contacts("Lucas", "lucas@gmail.com","55519988888");

        contactsDAO.addContact(contato);
    }
}

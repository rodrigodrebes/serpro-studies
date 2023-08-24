package org.example.CRUD7POSTGRESETESTES.Application;

public class main {
    public static void main(String[] args) {

        ConnectionDB cdb = new ConnectionDB();
        cdb.createTables();
        ContactsDAO contactsDAO = new ContactsDAO();

        // add method
//        Contacts contato = new Contacts("Lucas", "lucas@gmail.com","55519988888");
//        contactsDAO.addContact(contato);

        // return all method
//        for(Contacts c:contactsDAO.getContactsList()){
//            System.out.println(c);
//        }

        // delete method
//        contactsDAO.removeContact(1);
//        for (Contacts c : contactsDAO.getContactsList()) {
//            System.out.println(c);
//        }

        // update method
//        Contacts contato = new Contacts("Lucas", "lucas@gmail.com","55519988888");
//        contactsDAO.addContact(contato);
//        for(Contacts c:contactsDAO.getContactsList()){
//            System.out.println(c);
//        }

//        Contacts contatoAtt = new Contacts(2, "Rodrigo", "r@gmail.com","5959598888");
//        contactsDAO.updateContact(contatoAtt);
//        for(Contacts c:contactsDAO.getContactsList()){
//            System.out.println(c);
//        }

//        // return by id
//        System.out.println(contactsDAO.getContactById(41));

//        // return by name
//        contactsDAO.addContact(new Contacts("Ana","a@gmail.com","5555555"));
//        for(Contacts c: contactsDAO.concactsListByName()){
//            System.out.println(c);
//        }
    }
}

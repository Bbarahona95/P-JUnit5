package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import principal.ContactManager;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    ContactManager contactManager;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        contactManager = new ContactManager();

    }

    @Test
    @DisplayName("Add contacts")
    void addContact() {
        contactManager.addContacts("11111111", "Benjamin", "Barahona", "50688616050");
        contactManager.addContacts("2222-2222", "Sebastian", "Barahona", "50687420427");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(2, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream().anyMatch(contact ->
                contact.getId().equals("11111111")
                        && contact.getFirstName().equals("Benjamin")
                        && contact.getLastName().equals("Barahona")
                        && contact.getPhoneNumber().equals("50688616050")));

    }
    @Test
    @DisplayName("Verifica Exception apellido nulo")
    void lanzaExceptionCuandoApellidoEsNulo(){
        Assertions.assertThrows(RuntimeException.class,() ->{
            contactManager.addContacts("11111111","Benjamin",null,"50688616050");
        });
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }
}
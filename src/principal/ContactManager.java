package principal;

import principal.Contact;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {
    Map<String, Contact> contactList = new ConcurrentHashMap<String, Contact>();

    public void addContacts(String id, String firstName, String LastName, String phoneNumber) {
        Contact newContact = new Contact(id, firstName, LastName, phoneNumber);
        validateContact(newContact);
        checkIfContactAlreadyExist(newContact);
        contactList.put(generateKey(newContact),newContact);
    }

    public Collection<Contact> getAllContacts() {
        return contactList.values();
    }

    private String generateKey(Contact newContact) {
        return String.format("%s-%s", newContact.getFirstName(), newContact.getLastName());
    }
    private void    checkIfContactAlreadyExist(Contact newContact){
        if(contactList.containsKey(generateKey(newContact))){
            throw new RuntimeException("The contact already exist");
        }
    }
    private void validateContact(Contact newContact){
        newContact.validateId();
        newContact.validateFirstName();
        newContact.validateLastName();
        newContact.validatePhoneNumber();
    }
}

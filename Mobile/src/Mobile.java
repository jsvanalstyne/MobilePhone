import java.util.ArrayList;

public class Mobile {

    private ArrayList <Contacts> contacts;
    private String myNumber;

    public Mobile(String myNumber) {
        this.myNumber = myNumber;
//        initialize the contact ArrayList;
        this.contacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact.getName()) >=0){
            System.out.println("Contact already in list.");
            return false;
        }
        contacts.add(contact);
        return true;
    }
//    method to find a contact. Receives the contact RECORD utilizing the contact class. Returns integer of the index of the contact if present.
    private int findContact(Contacts contact){
        return this.contacts.indexOf(contact);
    }
//    Looking for a contact based on name.
    private int  findContact(String contactName){
        for(int i=0; i<this.contacts.size(); i++){
            Contacts contact = this.contacts.get(i);
            if(contact.getName() == contactName){
                return i;
            }
        }
        return -1;

    }
    public boolean removeContact(Contacts contact){
        int foundContact = findContact(contact);
        if(foundContact < 0){
            System.out.println("Searched contact cannot be found");
            return false;
        } else{
            this.contacts.remove(foundContact);
            System.out.println("Contact " + contact.getName() + " has been removed from list");
            return true;
        }
    }
//    Method used to update and existing contact record.
    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundOldPosition = findContact(oldContact);
        if(foundOldPosition < 0){
            System.out.println("Searched contact cannot be found");
            return false;
        }
        this.contacts.set(foundOldPosition, newContact);
        System.out.println("Contact " + oldContact+ " has been updated to "+ newContact);
        return true;
    }
//    Method used to search the entire contacts records for a specific contact and return that contact's name.
    public String queryContact (Contacts contact){
//        utilizes the findContact method on line 23 to find the
        if(findContact(contact) >=0){
            return contact.getName();
        } else{
            return null;
        }
    }

}

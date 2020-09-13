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
    public int findContact(Contacts contact){
        return this.contacts.indexOf(contacts);
    }
//    Looking for a contact based on name.
    public int  findContact(String contactName){
        for(int i=0; i<this.contacts.size(); i++){
            Contacts contact = this.contacts.get(i);
            if(contact.getName() == contactName){
                return i;
            }
        }
        return -1;

    }
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

}

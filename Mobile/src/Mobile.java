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
        if(searchContacts(contact.getName()) >=0){
            System.out.println("Contact already in list.");
            return false;
        }
        contacts.add(contact);
        return true;
    }
    public int findContact(Contacts contact){
        return
    }
    public int  searchContacts(String contact){
        int contactIndex = contacts.indexOf(contact);
        if (contactIndex >= 0){
            return contactIndex;
        }else{
            return -1;
        }


    }

}

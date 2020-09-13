import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Mobile mobilePhone = new Mobile("123 456 7890");
    public static void main(String[] args) {

    boolean quit = false;

    startPhone();
    printActions();
        while(!quit) {
            System.out.println("Enter action: (6 to 0 actions to show)" );
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    quit  =true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }


    }
    public static void printActions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To shutdown.");
        System.out.println("\t 1 - To print contacts");
        System.out.println("\t 2 - To add an contact record.");
        System.out.println("\t 3 - To update an exisitng contact record.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To find a contact.");
        System.out.println("\t 6 - To print instructions");
        System.out.println("Choose your action: ");
    }
    private static void printContacts(){
        mobilePhone.printContacts();
    }
    public static void startPhone(){
        System.out.println("Starting a phone...");
    }
    public static void addContact(){
        System.out.println("Enter contact name: ");
        String name =scanner.nextLine();
        System.out.println("Enter contact number: ");
        String phoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContactRecord(name, phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: "+ name + " " + phoneNumber);
        } else{
            System.out.println("Cannot add contact. Name already on file. ");
        }


    }
    private static void updateContact(){
        System.out.println("Enter contact name for updating: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("No contact found");
            return;
        }
        System.out.println("Enter updated name: ");
        String updatedName = scanner.nextLine();
        System.out.println("Enter updated phone number: ");
        String updatedNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContactRecord(updatedName, updatedNumber);
        if(mobilePhone.updateContact(existingContact, newContact)){
            System.out.println("Updating recored successful");
        } else{
            System.out.println("Error updating record");
        }

    }
    private static void removeContact() {
        System.out.println("Enter contact name for removal: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("No contact found");
            return;
        } else {
            if(mobilePhone.removeContact(existingContact)){
                System.out.println("Contact removed");
            } else{
                System.out.println("Error removing contact");
            }

        }
    }
    private static void searchContact(){
        System.out.println("Enter contact name for removal: ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("No contact found");
            return;


        }
        System.out.println("Name " + existingContact.getName()+ " phone number " + existingContact.getPhoneNumber());
    }
}

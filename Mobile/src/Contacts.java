public class Contacts{
    private String name;
    private String phoneNumber;
//Constuctor for the contacts class
    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
//    Calls on the constructor to create a new contact record.
    public static Contacts createContactRecord(String name, String phoneNumber){
        return new Contacts(name, phoneNumber);
    }
}

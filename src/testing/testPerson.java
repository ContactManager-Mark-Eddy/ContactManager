package testing;

public class testPerson {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;

    private static int contactCounter = 0;

    public testPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        contactCounter++;
    }

    public testPerson(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName + ";";
        this.lastName = lastName + ";";
        this.phoneNumber = phoneNumber + ";";
        contactCounter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public static int getContactCounter() {
        return contactCounter;
    }

    public testPerson(String firstName, String lastName, String address, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        contactCounter++;
    }
}

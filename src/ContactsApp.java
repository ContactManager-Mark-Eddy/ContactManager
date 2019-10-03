import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContactsApp {

    private static ArrayList<Contacts> fullList = new ArrayList<>();

    public static void main(String[] args) {

        readTxt();

        displayMenu();

    }

/////////////////////// displays main menu ///////////////////////

    public static void displayMenu() {
        Input input = new Input();

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");

        int choice = input.getInt("Enter an option (1, 2, 3, 4 or 5):");

        if (choice == 1) {
            displayAll();
            displayMenu();
        } else if (choice == 2) {
            addPerson();
            displayMenu();
        } else if(choice == 3){
            contactSearch();
            displayMenu();
        } else if (choice == 4){
            deleteContact();
            displayMenu();
        } else if (choice == 5){
            writeToFile();
        }

    }

/////////////////////// displays the current array list ///////////////////////


    public static void displayAll(){


        System.out.println("Name | Phone number\n" +
                "---------------\n");

        String parsedFirst;
        String parsedLast;
        String parsedNum;

        for (Contacts contact: fullList) {

            parsedFirst = contact.getFname();

            parsedLast = contact.getLname();

            parsedNum = contact.getPhone();

        System.out.println(parsedFirst + " " + parsedLast + " | " + parsedNum + "\n");

        }
    }


/////////////////////// adds to the current array list ///////////////////////

    public static void addPerson() {
        Input input = new Input();
        String f = input.getString("Enter First Name");
        String l = input.getString("Enter Last Name");
        String n = input.getString("Enter Number");

        Contacts newContact = new Contacts(f, l, n);
        fullList.add(newContact);
//        System.out.println(fullList);


    }

/////////////////////// initial txt file load and turns into array list of contacts objects ///////////////////////

    public static void readTxt() {

        Path testFile = Paths.get("contacts.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(testFile);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("did not work");
        }

        String[] parsedString;
        for (String contact : lines) {
            parsedString = contact.split(";");

            Contacts addContact = new Contacts(parsedString[0],parsedString[1],parsedString[2]);
            fullList.add(addContact);

        }
//        System.out.println(fullList);

    }


/////////////////////// searches the current array list ///////////////////////

    public static void contactSearch(){
        Input input = new Input();

        int choice = input.getInt("1. search first name.\n" +
                "2. search last name.\n" +
                "3. search by number.\n");
        switch(choice){
            case 1:
                String search = input.getString("enter first name to search");

                for (Contacts contacts: fullList) {
                    if(contacts.getFname().toLowerCase().contains(search.toLowerCase())){
                        System.out.println(contacts.getFname() + " " + contacts.getLname() + " | " + contacts.getPhone() + "\n");
                    }
                }
                break;
            case 2:
                String search2 = input.getString("enter last name to search");
                for (Contacts contacts: fullList) {
                    if(contacts.getLname().toLowerCase().contains(search2.toLowerCase())){
                        System.out.println(contacts.getFname() + " " + contacts.getLname() + " | " + contacts.getPhone() + "\n");
                    }
                }
                break;
            case 3:
                String search3 = input.getString("enter phone number to search");
                for (Contacts contacts: fullList) {
                    if(contacts.getPhone().toLowerCase().contains(search3.toLowerCase())){
                        System.out.println(contacts.getFname() + " " + contacts.getLname() + " | " + contacts.getPhone() + "\n");
                    }
                }
                break;
            default:
                System.out.println("please select either 1, 2, or 3");
                contactSearch();
        }
    }


/////////////////////// deletes contact from the array list ///////////////////////

    public static void  deleteContact() {
        Input input = new Input();


        int count = 1;

        System.out.println("Name | Phone number\n" +
                "---------------\n");

        String parsedFirst;
        String parsedLast;
        String parsedNum;

        for (Contacts contact : fullList) {

            parsedFirst = contact.getFname();

            parsedLast = contact.getLname();

            parsedNum = contact.getPhone();

            System.out.println(count + ". " + parsedFirst + " " + parsedLast + " | " + parsedNum + "\n");
            count++;

        }

        int choice = input.getInt("enter number to delete");

            fullList.remove(choice - 1);
    }


/////////////////////// transforms array list to formatted string and sends to file ///////////////////////

    public static void  writeToFile(){

        System.out.println(fullList);

        List<String> newlist = new ArrayList<>();

        for(Contacts contact: fullList){
            newlist.add(contact.getFname() + ";" + contact.getLname() + ";" + contact.getPhone());
        }

        Path addTxt = Paths.get("contacts.txt");

        try{
            Files.write(addTxt, newlist);
        } catch (IOException e){
            e.printStackTrace();
        }


    }

}

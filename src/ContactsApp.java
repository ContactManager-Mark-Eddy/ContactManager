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
//
//        Contacts contact = new Contacts("Micheal", "Debrah", "21002038503");
//        Path addContact = Paths.get("contacts.txt");

//        String test1 = addContact.toString();
//
//        System.out.println(readFileIntoList(test1));

    }

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
        } else if (choice == 5){
            writeToFile();
        }

    }

    public static void displayAll(){


        System.out.println("Name | Phone number\n" +
                "---------------\n");

        String parsedFirst;
        String parsedLast;
        String parsedNum;


        for (Contacts contact: fullList) {

            parsedFirst = contact.getFname();

//            StringBuilder first = new StringBuilder(parsedFirst);
//            first = first.deleteCharAt(first.length()-1);
//            parsedFirst = first.toString();

            parsedLast = contact.getLname();

//        StringBuilder last = new StringBuilder(parsedLast);
//            last = last.deleteCharAt(last.length()-1);
//            parsedLast = last.toString();

            parsedNum = contact.getPhone();

//        StringBuilder num = new StringBuilder(parsedNum);
//            num = num.deleteCharAt(num.length()-1);
//            parsedNum = num.toString();

        System.out.println(parsedFirst + " " + parsedLast + " | " + parsedNum + "\n");

        }
    }



    public static void addPerson() {
        Input input = new Input();
        String f = input.getString("Enter First Name");
        String l = input.getString("Enter Last Name");
        String n = input.getString("Enter Number");

        Contacts newContact = new Contacts(f, l, n);
        fullList.add(newContact);
        System.out.println(fullList);


    }

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
        System.out.println(fullList);

    }



    public static void contactSearch(){
        Input input = new Input();

        int choice = input.getInt("\"1. search first name.\\n\" +\n" +
                "                \"2. search last name.\\n\" +\n" +
                "                \"3. search by number.\\n\"");

        switch(choice){
            case 1:

                String search = input.getString("enter name to search");

                for (Contacts contacts: fullList) {
                    if(search.equalsIgnoreCase(contacts.getFname())){
                        System.out.println(contacts.getFname());
                    }else {
                        System.out.println("nope");
                    }

                }

                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("please select either 1, 2, or 3");
                contactSearch();
        }
    }


    public static void  writeToFile(){

        List<String> newlist = new ArrayList<>();

        for(Contacts contact: fullList){
            newlist.add(contact.getFname() + ";" + contact.getLname() + ";" + contact.getPhone());
        }

        Path addTxt = Paths.get("contact.txt");

        try{
            Files.write(addTxt, newlist);
        } catch (IOException e){
            e.printStackTrace();
        }


    }

}

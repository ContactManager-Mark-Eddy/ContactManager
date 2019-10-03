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
//        addPerson();
        displayMethod();
//
//        Contacts contact = new Contacts("Micheal", "Debrah", "21002038503");
//        Path addContact = Paths.get("contacts.txt");

//        String test1 = addContact.toString();
//
//        System.out.println(readFileIntoList(test1));

    }

    public static void displayMethod() {
        Input input = new Input();

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n");

        int choice = input.getInt("Enter an option (1, 2, 3, 4 or 5):");

        if (choice == 1) {
            displayAll();
            displayMethod();
        } else if (choice == 2) {
            addPerson();
            displayMethod();
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
            parsedLast = contact.getLname();
            parsedNum = contact.getPhone();

        System.out.println(parsedFirst + " " + parsedLast + " | " + parsedNum + "\n");

        }
    }


//    public static List<String> readFileIntoList(String file) {
//        List<String> lines = Collections.emptyList();
//        try {
//            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        System.out.println(lines);
//        return lines;
//
//    }


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
            System.out.println("Tha did not work");
        }
//        System.out.println(lines.get(0));


        String[] parsedString;
        for (String contact : lines) {
            parsedString = contact.split(";");

            Contacts addContact = new Contacts(parsedString[0],parsedString[1],parsedString[2]);
//            System.out.println(parsedString[0] + " " + parsedString[1] + " | " + parsedString[2] + "\n");
            fullList.add(addContact);

        }
        System.out.println(fullList);

    }

}

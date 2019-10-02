import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContactsApp {

    public static void main(String[] args) {
//        displayMethod();
//
//        Contacts contact = new Contacts("Micheal", "Debrah", "21002038503");
        Path addContact = Paths.get("contacts.txt");

        String test1 = addContact.toString();

        System.out.println(readFileIntoList(test1));

    }

    public static void displayMethod() {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
    }

    public static List<String> readFileIntoList(String file) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lines);
        return lines;

    }

}

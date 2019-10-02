package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class testMain {

    public static void main(String[] args) {
        ArrayList<testPerson> contactList = new ArrayList <testPerson> ();
        readFile(contactList);

        System.out.println(contactList.get(1).getFirstName());
    }

    public static void readFile(ArrayList <testPerson> contactList){
//        try{
//            Scanner read = new Scanner(new File( "contacts.txt"));
//            do{
//                String line = read.nextLine();
//                String[] parsedString = line.split(";");
//
//                contactList.add(new testPerson(parsedString[0], parsedString[1], parsedString[2]));
//            }while(read.hasNext());
//            read.close();
//        }catch(FileNotFoundException fnf){
//            System.out.println("File was not found.");
//        }

        try{
//            Scanner read = new Scanner(new File( "contacts.txt"));

//                String line = read.nextLine();

                String line = "mark;eddy;210";
                String[] parsedString = line.split(";");

                contactList.add(new testPerson(parsedString[0], parsedString[1], parsedString[2]));
                contactList.add(new testPerson(parsedString[0], parsedString[1], parsedString[2]));
//            System.out.println(parsedString[0] + parsedString[1] + parsedString[2]);

        }catch(Exception fnf){
            System.out.println("File was not found.");
        }
    }}

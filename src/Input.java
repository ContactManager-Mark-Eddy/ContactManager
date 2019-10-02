import java.util.Scanner;

public class Input {


    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }


    private String getString(){
        return this.scanner.nextLine();
    }

    public String getString(String prompt){
        if(prompt.isEmpty()){
            System.out.println("Type something: ");
        } else {
            System.out.println(prompt);
        }
        return getString();
    }


    public boolean yesNo(){
        System.out.println("Y/N?");

        String input = this.scanner.nextLine().trim();

        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");

    };


    public int getInt(int min, int max) {


        do {
            System.out.println("enter a number between " + min + " and " + max);

            String userInput = this.scanner.nextLine();
            int num;
            try {
                num = Integer.valueOf(userInput);
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a number");
                return getInt(min, max);
            }

            if (num >= min && num <= max) {
                return num;
            }else {
                System.out.println("that is not between " + min + " and " + max);
            }
        } while (true);
    }

    public int getInt(int min, int max, String prompt) {

        do {
            System.out.println(prompt);

            String userInput = this.scanner.nextLine();
            int num;
            try {
                num = Integer.valueOf(userInput);
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a number");
                return getInt(min, max, prompt);
            }

            if (num >= min && num <= max) {
                return num;
            }else {
                System.out.println("that is not between " + min + " and " + max);
            }
        } while (true);
    }



    public int getInt() {
        System.out.println("enter a number:");

        String userInput;
        userInput = this.scanner.nextLine();
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            System.out.println(userInput + " is not a number");
            return getInt();
        }
    }


    public int getInt(String prompt){
        System.out.println(prompt);

        String userInput;
        userInput = this.scanner.nextLine();
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            System.out.println(userInput + " is not a number");
            return getInt(prompt);
        }
    }


    public double getDouble(double min, double max) {


        do {
            System.out.println("enter a number between " + min + " and " + max);

            String userInput = this.scanner.nextLine();
            double num;
            try {
                num = Integer.valueOf(userInput);
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a number");
                return getDouble(min, max);
            }

            if (num >= min && num <= max) {
                return num;
            }else {
                System.out.println("that is not between " + min + " and " + max);
            }
        } while (true);
    }

    public double getDouble(double min, double max, String prompt) {

        do {
            System.out.println(prompt);

            String userInput = this.scanner.nextLine();
            double num;
            try {
                num = Integer.valueOf(userInput);
            } catch (NumberFormatException e) {
                System.out.println(userInput + " is not a number");
                return getDouble(min, max, prompt);
            }

            if (num >= min && num <= max) {
                return num;
            }else {
                System.out.println("that is not between " + min + " and " + max);
            }
        } while (true);
    }



    public double getDouble() {
        System.out.println("enter a number:");

        String userInput;
        userInput = this.scanner.nextLine();
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            System.out.println(userInput + " is not a number");
            return getDouble();
        }
    }


    public double getDouble(String prompt){
        System.out.println(prompt);

        String userInput;
        userInput = this.scanner.nextLine();
        try {
            return Integer.valueOf(userInput);
        } catch (NumberFormatException e) {
            System.out.println(userInput + " is not a number");
            return getDouble(prompt);
        }
    }


    public int getBinary() {
        int input;
        try {
            System.out.println("enter a binary number");
            input = Integer.parseInt(scanner.nextLine(), 2);
        } catch (NumberFormatException e) {
            System.out.println("not a binary number");
            return getBinary();
        }
        return input;
    }


    public int getHex(){
        int input;
        try {
            System.out.println("enter a hexadecimal number");
            input = Integer.parseInt(scanner.nextLine(), 16);
        } catch (NumberFormatException e) {
            System.out.println("not a hexadecimal");
            return getHex();
        }
        return input;
    }
}
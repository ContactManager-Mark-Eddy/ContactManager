import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Contacts implements Serializable {
    private String fname;
    private String lname;
    private String phone;


    public Contacts(String firstName, String lastName, String num) {
        this.fname = firstName + ";";
        this.lname = lastName + ";";
        this.phone = num + ";";

    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }



}

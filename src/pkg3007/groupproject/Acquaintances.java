package pkg3007.groupproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author WH
 */
import java.io.Serializable;
import java.util.Scanner;

public class Acquaintances extends AcquaintanceComponent implements Serializable {

    private String Name;
    private String MobileNo;
    private String Email;
    public static int number = 0;

    Acquaintances() {
        number++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Scanner reader = new Scanner(System.in);
        if (!name.isEmpty()) {
            this.Name = name;
        } else {
            System.out.println("Enter atleast one character");
            setName(reader.nextLine());
        }
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}

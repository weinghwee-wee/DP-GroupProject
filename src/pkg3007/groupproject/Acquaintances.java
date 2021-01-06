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
import java.util.Iterator;
import java.util.Scanner;

public abstract class Acquaintances extends AcquaintanceComponent implements Serializable {

    private String country;
    private String Name;
    private String MobileNo;
    private String Email;
    public static int number = 0;

    Acquaintances() {
        number++;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String print() {
        String s = "";
        s = s.concat("Name: " + getName() + "<br>");
        s = s.concat("Mobile No: " + getMobileNo() + "<br>");
        s = s.concat("Email: " + getEmail() + "<br>");
        s = s.concat("Country: " + getCountry() + "<br>");
        
        return s;
    }

    public Iterator<AcquaintanceComponent> createIterator() {
        return new NullIterator();
    }
}

class NullIterator implements Iterator<AcquaintanceComponent> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public AcquaintanceComponent next() {
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3007.groupproject;

/**
 *
 * @author WH
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Relatives extends Acquaintances implements Serializable {

    private String BDate;
    private String LDate;
    public static int numberRel = 0;
    private static Scanner reader = new Scanner(System.in);

    Relatives() {
        numberRel++;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String Name) {
        super.setName(Name);
    }

    @Override
    public String getMobileNo() {
        return super.getMobileNo();
    }

    @Override
    public void setMobileNo(String MobileNo) {
        super.setMobileNo(MobileNo);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String Email) {
        super.setEmail(Email);
    }

    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getLDate() {
        return LDate;
    }

    public void setLDate(String LDate) {
        this.LDate = LDate;
    }

    public String print() {
        String s = "";
        s = s.concat(super.print());
        s = s.concat("Relatives Birthday: " + getBDate() + "<br>");
        s = s.concat("Last met date: " + getLDate() + "<br>");
        
        return s;
    }
}

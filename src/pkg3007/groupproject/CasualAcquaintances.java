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
import java.util.Scanner;

public abstract class CasualAcquaintances extends Acquaintances implements Serializable {

    private String WhenWhere;
    private String Circumstances;
    private String OtherInfo;
    public static int numberCA = 0;
    public abstract void updateCountry(String country);

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String Name) {
        super.setName(Name);
    }

    @Override
    public String getCountry() {
        return super.getCountry();
    }
    @Override
    public void setCountry(String country) {
        super.setCountry(country);
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

    public String getWhenWhere() {
        return WhenWhere;
    }

    public void setWhenWhere(String WhenWhere) {
        Scanner reader = new Scanner(System.in);

        if (!WhenWhere.isEmpty()) {
            this.WhenWhere = WhenWhere;
        } else {
            System.out.println("Enter atleast one character");
            setWhenWhere(reader.nextLine());
        }
    }

    public String getCircumstances() {
        return Circumstances;
    }

    public void setCircumstances(String Circumstances) {
        Scanner reader = new Scanner(System.in);
        if (!Circumstances.isEmpty()) {
            this.Circumstances = Circumstances;
        } else {
            System.out.println("Enter atleast one character");
            setCircumstances(reader.nextLine());
        }
    }

    public String getOtherInfo() {
        return OtherInfo;
    }

    public void setOtherInfo(String OtherInfo) {
        Scanner reader = new Scanner(System.in);

        if (!OtherInfo.isEmpty()) {
            this.OtherInfo = OtherInfo;
        } else {
            System.out.println("Enter atleast one character");
            setOtherInfo(reader.nextLine());
        }
    }

    public String print() {
        String s = "";
        s = s.concat(super.print());
        s = s.concat("First met location & time: " + getWhenWhere() + "<br>");
        s = s.concat("First met circumstances: " + getCircumstances() + "<br>");
        s = s.concat("Other useful information: " + getOtherInfo() + "<br><br>");
        
        return s;
    }
    
    public String match(String str){
        String s = "";
        if(getName().matches(str)){
            s = s.concat(print());
        }
        
        return s;
    }
}

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

public class ProfessionalFriends extends Acquaintances implements Serializable{
    private String CommonInterests;
    public static int numberProF = 0;

    ProfessionalFriends(){
        numberProF++;
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
    
    public String getCommonInterests() {
        return CommonInterests;
    }
    
    public void setCommonInterests(String CommonInterests) {
        Scanner reader = new Scanner(System.in);
        
        if(!CommonInterests.isEmpty())
            this.CommonInterests = CommonInterests;
        else{
            System.out.println("Enter at least one character");
            setCommonInterests(reader.nextLine());
        }
    }
    
    public String print(){
        String s = "";
        s = s.concat(super.print());
        s = s.concat("Common Interests: " + getCommonInterests() + "<br>");

        return s;
    }
}
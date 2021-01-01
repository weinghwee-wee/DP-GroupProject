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
import java.util.Iterator;

public class AcquaintancePersonalFriends extends AcquaintanceComponent{
    Iterator iterator;
    
    public AcquaintancePersonalFriends(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public String print() {
        String s = "";
        int i = 1;

        while(iterator.hasNext()){
            PersonalFriends perF = (PersonalFriends)
            iterator.next();
            s = s.concat(i+". Name: " + perF.getName() + "<br>");
            s = s.concat("Mobile No: " + perF.getMobileNo() +
            "<br>");
            s = s.concat("Email: " + perF.getEmail() + "<br>");
            s = s.concat("Specific events: " + perF.getEvents() +
            "<br>");
            s = s.concat("First Acquaintance context: " +
            perF.getAContext() + "<br>");
            s = s.concat("First Acquaintance date: " +
            perF.getADate() + "<br>");

            i++;
        }
        return s;
    }
}
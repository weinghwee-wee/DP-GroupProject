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

public class AcquaintanceCasualFriends extends AcquaintanceComponent{
    Iterator iterator;
     
    public AcquaintanceCasualFriends(Iterator iterator) {
        this.iterator = iterator;
    }
    
    @Override
    public String print() {
        String s = "";
        int i = 1;
        while(iterator.hasNext()){
            CasualAcquaintances ca = (CasualAcquaintances)
           iterator.next();
            s = s.concat(i+". Name: " + ca.getName() + "<br>");
            s = s.concat("Mobile No: " + ca.getMobileNo() +
           "<br>");
            s = s.concat("Email: " + ca.getEmail() + "<br>");
            s = s.concat("First met location & time: " +
           ca.getWhenWhere() + "<br>");
            s = s.concat("First met circumstances: " +
           ca.getCircumstances() + "<br>");
            s = s.concat("Other useful information: " +
           ca.getOtherInfo() + "<br>");
           i++;    
        }   
     
        return s;
    }
}


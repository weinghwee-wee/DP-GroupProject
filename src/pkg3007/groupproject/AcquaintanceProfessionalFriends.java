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

public class AcquaintanceProfessionalFriends extends AcquaintanceComponent{
    Iterator iterator;
    
    public AcquaintanceProfessionalFriends(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public String print() {
        String s = "";
        int i = 1;
        
        while(iterator.hasNext()){
            ProfessionalFriends proF = (ProfessionalFriends)
            iterator.next();
            s = s.concat(i+". Name: " + proF.getName() + "<br>");
            s = s.concat("Mobile No: " + proF.getMobileNo() +
            "<br>");
            s = s.concat("Email: " + proF.getEmail() + "<br>");
            s = s.concat("Common Interests: " +
            proF.getCommonInterests() + "<br>");

            i++;
        }
        
        return s;
    }
}
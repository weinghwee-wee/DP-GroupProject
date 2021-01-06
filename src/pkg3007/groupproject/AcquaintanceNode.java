/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3007.groupproject;

import java.util.Iterator;

/**
 *
 * @author ganze
 */
public class AcquaintanceNode {

    AcquaintanceComponent allAcquaintance;

    public AcquaintanceNode(AcquaintanceComponent allAcquaintance) {
        this.allAcquaintance = allAcquaintance;
    }

    public String printSearchedAcquaintance(String str) {
        Iterator iterator = allAcquaintance.createIterator();
        int index = 0;
        String s = "";
        while (iterator.hasNext()) {
            AcquaintanceComponent acquaintanceComponent = (AcquaintanceComponent) iterator.next();

            if (acquaintanceComponent instanceof AcquaintanceList) {
                Iterator list = acquaintanceComponent.createIterator();
                String name = acquaintanceComponent.getName();
                int match = 0;
                while (list.hasNext()) {
                    AcquaintanceComponent acquaintanceItem = (AcquaintanceComponent) list.next();

                    if (acquaintanceItem.getName().equals(str)) {
                        if (match == 0) {
                            index++;
                            s = s.concat(index + ". " + name + "<br>");
                        }
                        s = s.concat(acquaintanceItem.print());
                        match = 1;
                    }
                }
            }
            
        }
        return s;
    }
}

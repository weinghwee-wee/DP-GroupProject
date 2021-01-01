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
import java.util.ArrayList;
import java.util.Iterator;

public class AcquaintanceTitle extends AcquaintanceComponent {
    ArrayList menuComponents = new ArrayList();
    String name;

    public AcquaintanceTitle(String name) {
        this.name = name;
    }

    @Override
    public void add(AcquaintanceComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(AcquaintanceComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String print() {
        String s = "";
        Iterator iterator = menuComponents.iterator();
        s = s.concat(getName());
        
        while (iterator.hasNext()) {
            AcquaintanceComponent menuComponent =
            (AcquaintanceComponent)iterator.next();
            s+=menuComponent.print();
        }
        
        return s;
    }
}
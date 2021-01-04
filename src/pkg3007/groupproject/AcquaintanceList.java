/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3007.groupproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Wah
 */
public class AcquaintanceList extends AcquaintanceComponent implements Serializable{
    ArrayList<AcquaintanceComponent> acquaintances = new ArrayList<>();
    String name;
    
    public AcquaintanceList(String name){
        this.name = name;
    }
    
    public void add(AcquaintanceComponent acquaintanceComponent){
        acquaintances.add(acquaintanceComponent);
    }
    
    public void remove(int i){
        acquaintances.remove(i);
    }
    
    public String getName(){
        return name;
    }
    
    public AcquaintanceComponent get(int i){
        return acquaintances.get(i);
    }
    
    public int size(){
        return acquaintances.size();
    }
    
}


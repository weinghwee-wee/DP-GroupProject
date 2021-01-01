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
abstract class Validator {
    String str;

    public Validator(String str) {
        this.str = str;
    }

    public boolean isValid(){
        if(!checkNull()){
            return checkValid();
        } else{
            return false;
        }
    }

    public boolean checkNull(){
        return str.equalsIgnoreCase("");
    }

    public abstract boolean checkValid();
}
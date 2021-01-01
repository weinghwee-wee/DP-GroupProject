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

public class MobileNoChecker extends Validator{
    public MobileNoChecker(String str) {
        super(str);
    }
    
    @Override
    public boolean checkValid() {
        int x;
        
        if(str.length() < 6 || str.length() > 15)
            return false;
        
        for(int j = 0 ; j < str.length() ; j++) {
            x = (int)str.charAt(j);
            if( x < 48 || x > 57 )
            return false;
        }
        
        return true;
    }
}

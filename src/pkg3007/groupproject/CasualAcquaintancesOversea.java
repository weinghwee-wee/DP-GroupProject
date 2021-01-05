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
public class CasualAcquaintancesOversea extends CasualAcquaintances {
    CasualAcquaintancesOversea() {
        numberCA++;
    }
    
    @Override
    public void updateCountry(String country) {
       this.setCountry(country);
    }
}

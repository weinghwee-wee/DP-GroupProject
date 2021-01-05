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
public class AcquaintancesFactoryProvider {
    public AbstractFactory getAcquaintanceFactory(int i){
        switch (i) {
            case 0:
                return new AcquaintancesOverseaFactory();
            case 1:
                return new AcquaintancesLocalFactory();
            default:
                return null;
        }
    }
}

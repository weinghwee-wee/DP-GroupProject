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
public class AcquaintancesFactory {

    public Acquaintances getAcquaintance(int acquaintance){
        switch (acquaintance) {
            case 0:
                return new PersonalFriends();
            case 1:
                return new Relatives();
            case 2:
                return new ProfessionalFriends();
            default:
                return new CasualAcquaintances();
        }
    }
}


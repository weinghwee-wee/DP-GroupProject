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
public class AcquaintancesOverseaFactory extends AbstractFactory {
    
    @Override
    public Acquaintances getAcquaintance(int acquaintance){
        switch (acquaintance) {
            case 0:
                return new PersonalFriendsOversea();
            case 1:
                return new RelativesOversea();
            case 2:
                return new ProfessionalFriendsOversea();
            default:
                return new CasualAcquaintancesOversea();
        }
    }
}

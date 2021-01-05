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
public class AcquaintancesLocalFactory extends AbstractFactory {

    @Override
    public Acquaintances getAcquaintance(int acquaintance){
        switch (acquaintance) {
            case 0:
                return new PersonalFriendsLocal();
            case 1:
                return new RelativesLocal();
            case 2:
                return new ProfessionalFriendsLocal();
            default:
                return new CasualAcquaintancesLocal();
        }
    }
}


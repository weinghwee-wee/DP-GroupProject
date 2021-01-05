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
public class PersonalFriendsOversea extends PersonalFriends{
    PersonalFriendsOversea() {
        numberPerF++;
    }
    
    public void updateCountry(String country) {
       this.setCountry(country);
    }
}

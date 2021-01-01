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
import java.io.Serializable;
import java.util.ArrayList;

public class ContactManagementSoftware implements Serializable{
    private static MUI mg;
    private static ArrayList<ArrayList<Acquaintances>> a = new ArrayList<>();
    private static ArrayList<Acquaintances> perF1 = new ArrayList<>();
    private static ArrayList<Acquaintances> rel1 = new ArrayList<>();
    private static ArrayList<Acquaintances> proF1 = new ArrayList<>();
    private static ArrayList<Acquaintances> ca1 = new ArrayList<>();

    public static void main(String[] args) {
        mg = MUI.getMUI();
        a.add(perF1);
        a.add(rel1);
        a.add(proF1);
        a.add(ca1);
        mg.setMg(mg);
        mg.setA(a);
        mg.setVisible(true);
    }
}

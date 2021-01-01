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
import java.util.ArrayList;
import javax.swing.JApplet;

public class CLJApplet extends JApplet {
    private static ArrayList<ArrayList<Acquaintances>> a = new ArrayList<>();
    private static ArrayList<Acquaintances> perF1 = new ArrayList<>();
    private static ArrayList<Acquaintances> rel1 = new ArrayList<>();
    private static ArrayList<Acquaintances> proF1 = new ArrayList<>();
    private static ArrayList<Acquaintances> ca1 = new ArrayList<>();

    @Override
    public void init() {
        MUI mg = MUI.getMUI();
        
        a.add(perF1);
        a.add(rel1);
        a.add(proF1);
        a.add(ca1);
        this.add(mg.getContentPane());
        this.setSize(mg.getContentPane().getSize());
        this.setMinimumSize(mg.getContentPane().getSize());
        mg.setMg(mg);
        mg.setA(a);
    }
}

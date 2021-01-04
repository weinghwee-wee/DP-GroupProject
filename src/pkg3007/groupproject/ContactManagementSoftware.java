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

    private static AcquaintanceComponent rootDir = new AcquaintanceList("");
    private static AcquaintanceComponent perF1 = new AcquaintanceList("Personal Friends");
    private static AcquaintanceComponent rel1 = new AcquaintanceList("Relatives");
    private static AcquaintanceComponent proF1 = new AcquaintanceList("Professional Friends");
    private static AcquaintanceComponent ca1 = new AcquaintanceList("Casual Friends");

    public static void main(String[] args) {
        mg = MUI.getMUI();
        rootDir.add(perF1);
        rootDir.add(rel1);
        rootDir.add(proF1);
        rootDir.add(ca1);
        mg.setMg(mg);
        mg.setA(rootDir);
        mg.setVisible(true);
    }
}

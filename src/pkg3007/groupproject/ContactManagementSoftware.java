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
    
    private static AcquaintanceComponent personalOversea = new AcquaintanceList("Personal Friends Oversea");
    private static AcquaintanceComponent personalLocal = new AcquaintanceList("Personal Friends Local");
    
    private static AcquaintanceComponent relativeOversea = new AcquaintanceList("Relatives Oversea");
    private static AcquaintanceComponent relativeLocal = new AcquaintanceList("Relatives Local");
    
    private static AcquaintanceComponent professionalOversea = new AcquaintanceList("Professional Friends Oversea");
    private static AcquaintanceComponent professionalLocal = new AcquaintanceList("Professional Friends Local");
    
    private static AcquaintanceComponent casualOversea = new AcquaintanceList("Casual Friends Oversea");
    private static AcquaintanceComponent casualLocal = new AcquaintanceList("Casual Friends Local");

    public static void main(String[] args) {
        mg = MUI.getMUI();
        mg.initMuiClass();
        rootDir.add(personalOversea);
        rootDir.add(personalLocal);
        
        rootDir.add(relativeOversea);
        rootDir.add(relativeLocal);
        
        rootDir.add(professionalOversea);
        rootDir.add(professionalLocal);
        
        rootDir.add(casualOversea);
        rootDir.add(casualLocal);
        
        mg.setMg(mg);
        mg.setA(rootDir);
        mg.setVisible(true);
    }
}

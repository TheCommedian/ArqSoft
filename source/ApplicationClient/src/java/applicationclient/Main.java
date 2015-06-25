/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package applicationclient;

import adminclient.AdminClientEmulator;
import core.TurnSource;
import core.TurnSourceNotFoundException;
import externalclient.ExternalClientEmulator;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        AdminClientEmulator.addSource(new TurnSource(1, "Desc", "A1"));
        System.out.println("Test source added");
        System.out.println("Source count is: " + AdminClientEmulator.getTurnSources().size());
        
        try {
            ExternalClientEmulator.notifyChanges(1, "A2");
            System.out.println("Turn on source 1 has changed to: "
                    + ExternalClientEmulator.getCurrentTurn(1));
            
        } catch (TurnSourceNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        System.in.read();
    }
    
}

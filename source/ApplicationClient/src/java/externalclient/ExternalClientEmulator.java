/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package externalclient;

import adminclient.AdminClientEmulator;
import common.Constants;
import core.SourceCatalogBeanRemote;
import core.TurnBeanRemote;
import core.TurnSourceNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
public class ExternalClientEmulator {
    
    private static TurnBeanRemote turnBean;
    
    static {
        //try {
            //turnBean = (TurnBeanRemote) InitialContext
            //        .doLookup(Constants.TurnBeanJNDIName);
        //} catch (NamingException ex) {
        //    Logger.getLogger(AdminClientEmulator.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
    
    public static void notifyChanges(int sourceId, String currentTurn) throws TurnSourceNotFoundException {
        if (turnBean != null) {
            turnBean.notifyChanges(sourceId, currentTurn);
        }
    }
    
        
    public static String getCurrentTurn(int sourceId) throws TurnSourceNotFoundException {
        String result = null;
        
        if (turnBean != null) {
            result = turnBean.getCurrentTurn(sourceId);
        }
        
        return result;
    } 
}

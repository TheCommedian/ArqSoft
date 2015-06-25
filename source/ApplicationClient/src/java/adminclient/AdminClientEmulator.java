/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adminclient;

import common.Constants;
import core.SourceCatalogBeanRemote;
import core.TurnSource;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author IEUser
 */
public class AdminClientEmulator {
    
    private static SourceCatalogBeanRemote sourceCatalogBean;
    
    static {
        try {
            sourceCatalogBean = (SourceCatalogBeanRemote) InitialContext
                    .doLookup(Constants.SourceCatalogBeanJNDIName);
            
        } catch (NamingException ex) {
            Logger.getLogger(AdminClientEmulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addSource(TurnSource ts) {
        if (sourceCatalogBean != null) {
            sourceCatalogBean.addSource(ts);
        }
    }
    
    public static List<TurnSource> getTurnSources() {
        List<TurnSource> result = null;
        
        if (sourceCatalogBean != null) {
            result = sourceCatalogBean.getTurnSources();
        }
        
        return result;
    }
}

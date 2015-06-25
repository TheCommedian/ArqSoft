/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import javax.ejb.Remote;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Remote
public interface TurnBeanRemote {
    
    void notifyChanges(final int sourceId, final String turnId) throws TurnSourceNotFoundException;
    
    String getCurrentTurn(final int sourceId) throws TurnSourceNotFoundException;
}

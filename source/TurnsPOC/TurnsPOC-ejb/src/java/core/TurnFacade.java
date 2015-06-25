/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import common.Constants;

import java.util.Optional;
import javax.ejb.Singleton;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Singleton
public class TurnFacade implements TurnFacadeRemote {

    /**
     *
     * @param sourceId is the id of the turnSoruce
     * @param turnId is the id of the turn that has changed
     */
    @Override
    public void notifyChanges(final int sourceId, final String turnId) throws TurnSourceNotFoundException {
        Optional<TurnSource> source = SourceCatalog.getInstance()
               .findSourceById(sourceId);
 
        if (source.isPresent()) {
            source.get().setCurrentTurn(turnId); 
        } else {
            throw new TurnSourceNotFoundException(String.format(
                    Constants.SOURCE_NOT_FOUND_EXCEPTION_MESSAGE, sourceId));
        }
    }

    @Override
    public String getCurrentTurn(final int sourceId) throws TurnSourceNotFoundException {
        String result = null;
        
        Optional<TurnSource> source = SourceCatalog.getInstance()
               .findSourceById(sourceId);
        
        if (source.isPresent()) {
            result = source.get().getCurrentTurn();
        } else {
            throw new TurnSourceNotFoundException(String.format(
                    Constants.SOURCE_NOT_FOUND_EXCEPTION_MESSAGE, sourceId));
        }
        
        return result;
    }
}

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
public class UserFacade implements UserFacadeLocal {

    @Override
    public void registerByPhoneNumber(final String phoneNumber, String turnId, int sourceId, int channelId)
        throws 
            TurnSourceNotFoundException,
            ChannelNotFoundExcepcion {
        
        Optional<TurnSource> source = SourceCatalog.getInstance().findSourceById(sourceId);
        Optional<ITurnObserver> observer;

        if (source.isPresent()) {
            observer = source.get().findObserverById(channelId);
        } else {
            throw new TurnSourceNotFoundException(String.format(
                    Constants.SOURCE_NOT_FOUND_EXCEPTION_MESSAGE, sourceId));
        }
        
        if (observer.isPresent()) {
            observer.get().registerUser(new User(
                    phoneNumber,
                    turnId));
        } else {
            throw new ChannelNotFoundExcepcion(String.format(
                    Constants.CHANNEL_NOT_FOUND_EXCEPTION_MESSAGE, channelId));
        }
    }           
}

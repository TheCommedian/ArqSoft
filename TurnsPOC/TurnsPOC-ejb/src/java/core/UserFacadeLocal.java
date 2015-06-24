/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import javax.ejb.Local;

/**
 *
 * @author IEUser
 */
@Local
public interface UserFacadeLocal {

    void registerByPhoneNumber(final String phoneNumber, String turnId, int sourceId, int channelId)
            throws 
                TurnSourceNotFoundException,
                ChannelNotFoundExcepcion;
}

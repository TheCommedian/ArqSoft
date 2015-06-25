/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author IEUser
 */
public interface TurnObserver extends Serializable {
    void registerUser(User user);
    
    void notifyTurn(String turnId);
    
    int getObserverId();
    
    List<User> getRegisteredUsers();
}

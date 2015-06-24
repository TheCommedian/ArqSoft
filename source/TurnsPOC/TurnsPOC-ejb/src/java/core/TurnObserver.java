/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.List;

/**
 *
 * @author IEUser
 */
public interface TurnObserver {
    void registerUser(User user);
    
    void notifyTurn();
    
    int getObserverId();
    
    List<User> getRegisteredUsers();
}

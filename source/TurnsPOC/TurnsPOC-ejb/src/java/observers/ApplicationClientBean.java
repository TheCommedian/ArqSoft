/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import core.TurnObserver;
import core.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Singleton
public class ApplicationClientBean implements ApplicationClientBeanRemote, TurnObserver {

    private List<User> registeredUsers;

    public ApplicationClientBean() {
        this.registeredUsers = new ArrayList<>();
    }
    
    @Override
    public void notify(String turnId) {
        Logger.getLogger(ApplicationClientBean.class.getName()).log(Level.INFO, "Turn changed: {0}", turnId);
    }

    @Override
    public void registerUser(User user) {
        if (user != null) {
            this.registeredUsers.add(user);
        }
    }

    @Override
    public void notifyTurn() {
        this.registeredUsers.forEach(u -> { 
            System.out.println("El turno ha cambiado!"); });
    }

    @Override
    public int getObserverId() {
        return  1;
    }

    @Override
    public List<User> getRegisteredUsers() {
        return this.registeredUsers;
    }
}

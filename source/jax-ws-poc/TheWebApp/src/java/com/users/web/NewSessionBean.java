/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.web;

import com.users.model.UserController;
import com.users.model.Users;
import javax.ejb.Stateless;

/**
 *
 * @author IEUser
 */
@Stateless
public class NewSessionBean {
  
    
    public Users[] getUsers() {
        return users;
    }

    public void setUsers(Users[] users) {
        this.users = users;
    }
    private Users[] users;
    
    public void updateUsers(){
     UserController usersController = new UserController();
     users = usersController.getUsers();
      }  
   
}



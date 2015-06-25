/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datafacadetest;

//import data.DataFacade;
//import data.UserEntity;
import data.DataFacade;
import data.UserEntity;
import data.TurnSourceEntity;

import java.util.List;

/**
 *
 * @author IEUser
 */
public class DataFacadeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UserEntity user;
        Long id;
        
        user = new UserEntity();
        user.setPhoneNumber("11111");
        user.setTurnId("1");
        id = DataFacade.create(user);
        
        user = new UserEntity();
        user.setPhoneNumber("44444");
        user.setTurnId("4");
        id = DataFacade.create(user);
        
        user = new UserEntity();
        user.setPhoneNumber("2222");
        user.setTurnId("3");
        id =  DataFacade.create(user);
        
        List<UserEntity> users;               
        users = DataFacade.getAllUsers();
        
        UserEntity userUpdate = users.get(0);
        userUpdate.setPhoneNumber("909090");
        DataFacade.edit(userUpdate);
        
        TurnSourceEntity turnSource = new TurnSourceEntity();
        turnSource.setDescription("turno antel");
        turnSource.setCurrentTurn("3");
        id = DataFacade.create(turnSource);
        
        List<TurnSourceEntity> turns = DataFacade.getAllTurnSources();
        
        TurnSourceEntity turnUpdate = turns.get(0);
        turnUpdate.setCurrentTurn("909090");
        DataFacade.edit(turnUpdate);
        
        
    }
    
}

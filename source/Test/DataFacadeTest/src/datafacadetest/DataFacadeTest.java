/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datafacadetest;

//import data.DataFacade;
//import data.UserEntity;
import data.BaseEntity;
import data.UserEntity;
import data.DataFacade;
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
        DataFacade dataFacade = new DataFacade();
        UserEntity user;
        Long id;
        
        user = new UserEntity();
        user.setPhoneNumber("11111");
        user.setTurnId("1");
        id = dataFacade.create(user);
        
        user = new UserEntity();
        user.setPhoneNumber("44444");
        user.setTurnId("4");
        id = dataFacade.create(user);
        
        user = new UserEntity();
        user.setPhoneNumber("2222");
        user.setTurnId("3");
        id =  dataFacade.create(user);
        
        List<UserEntity> users;               
        users = dataFacade.getAllUsers();
        
        UserEntity userUpdate = users.get(0);
        userUpdate.setPhoneNumber("909090");
        dataFacade.edit(userUpdate);
        
        TurnSourceEntity turnSource = new TurnSourceEntity();
        turnSource.setDescription("turno antel");
        turnSource.setCurrentTurn("3");
        id = dataFacade.create(turnSource);
        
        List<TurnSourceEntity> turns = dataFacade.getAllTurnSources();
        
        TurnSourceEntity turnUpdate = turns.get(0);
        turnUpdate.setCurrentTurn("909090");
        dataFacade.edit(turnUpdate);
        
        
    }
    
}

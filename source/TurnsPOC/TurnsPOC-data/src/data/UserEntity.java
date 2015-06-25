package data;

import javax.persistence.Entity;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Entity
public class UserEntity extends BaseEntity {
    private String phoneNumber;
    private String turnId; 
    
    public String getTurnId() {
        return turnId;
    }
     
    public void setTurnId(String turnId) {
        this.turnId = turnId;
    }    
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }  
}

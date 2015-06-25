/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import common.StringUtils;
import java.io.Serializable;

/**
 *
 * Marcelo Barberena / Fernando Maidana
 */
public class User implements Serializable {
    
    private String phoneNumber;
    private String turnId;

    public User() {
        phoneNumber = "";
        turnId = "";
    }

    public User(String phoneNumber, String turnId) {
        StringUtils.validateNotNullOrEmpty(phoneNumber, "phoneNumber");
        StringUtils.validateNotNullOrEmpty(turnId, "turnId");
        
        this.phoneNumber = phoneNumber;
        this.turnId = turnId;
    }

    /**
     * Get the value of turnId
     *
     * @return the value of turnId
     */
    public String getTurnId() {
        return turnId;
    }

    /**
     * Set the value of turnId
     *
     * @param turnId new value of turnId
     */
    public void setTurnId(String turnId) {
        StringUtils.validateNotNullOrEmpty(turnId, "turnId");
        this.turnId = turnId;
    }

    /**
     *
     * @return the value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        StringUtils.validateNotNullOrEmpty(phoneNumber, "phoneNumber");
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += getPhoneNumber().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        
        User other = (User) object;
        if (this.getPhoneNumber() == null
                ? other.getPhoneNumber() != null 
                : !this.getPhoneNumber().equals(other.getPhoneNumber())) {
            return false;
        }
        
        return true;
    }
}

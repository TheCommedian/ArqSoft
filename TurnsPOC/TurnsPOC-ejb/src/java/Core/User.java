/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Common.StringUtils;

/**
 *
 * Marcelo Barberena / Fernando Maidana
 */
public class User {
    
    private String phoneNumber;
    private String turnId;

    public User()
    {
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
}

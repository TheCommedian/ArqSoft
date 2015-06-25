/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import javax.persistence.Entity;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Entity
public class TurnSourceEntity extends BaseEntity {
    private String description;
    private String currentTurn;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }     
}

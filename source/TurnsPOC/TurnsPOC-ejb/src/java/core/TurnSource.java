/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
import common.StringUtils;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author IEUser
 */
public class TurnSource implements Serializable {

    private int sourceId;
    private String description;
    private String currentTurn;
    private final List<TurnObserver> observers;
    
    public TurnSource() {
        description = "";
        currentTurn = "";
        sourceId = -1;
        observers = null;
    }

    public TurnSource(int sourceId, String description, String currentTurn) {
        StringUtils.validateNotNullOrEmpty(description, "description");
        StringUtils.validateNotNullOrEmpty(currentTurn, "currentTurn");
        
        this.sourceId = sourceId;
        this.description = description;
        this.currentTurn = currentTurn;
        this.observers = new ArrayList<>();
    }

    /**
     * Get the value of observers
     *
     * @return the value of observers
     */
    public List<TurnObserver> getObservers() {
        return observers;
    }

    /**
     * Get the value of currentTurn
     *
     * @return the value of currentTurn
     */
    public String getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Set the value of currentTurn
     *
     * @param currentTurn new value of currentTurn
     */
    public void setCurrentTurn(String currentTurn) {
        StringUtils.validateNotNullOrEmpty(currentTurn, "currentTurn");
        this.currentTurn = currentTurn;
        
        this.notifyObservers(currentTurn);
    }

    /**
     * Get the value of sourceId
     *
     * @return the value of sourceId
     */
    public int getSourceId() {
        return sourceId;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        StringUtils.validateNotNullOrEmpty(description, "description");
        this.description = description;
    }
    
    /**
     *
     * @param observer
     * @throws IllegalArgumentException
     */
    public void registerObserver(TurnObserver observer) throws IllegalArgumentException {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        
        observers.add(observer);
    }
    
    /**
     *
     * @param observer
     */
    public void removeObserver(TurnObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }
    
    /**
     *
     * @param observerId
     * @return the observer corresponding to the given ID (if found)
     */
    public Optional<TurnObserver> findObserverById(int observerId) {
        return observers.stream()
                .filter(o -> o.getObserverId() == observerId)
                .findFirst();
    }
    
    /**
     * Notify all observers when a turn change occurs
     * @param turnId
     */
    protected void notifyObservers(String turnId) {
        observers.stream().forEach((observer) -> { observer.notifyTurn(turnId); });
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sourceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnSource)) {
            return false;
        }
        
        TurnSource other = (TurnSource) object;
        if (this.sourceId != other.sourceId) {
            return false;
        }
        
        return true;
    }
    
}

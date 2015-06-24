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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurnSource {

    private int sourceId;
    private String description;
    private String currentTurn;
    private final List<ITurnObserver> observers;
    
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
    public List<ITurnObserver> getObservers() {
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
        
        this.notifyObservers();
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
    public void registerObserver(ITurnObserver observer) throws IllegalArgumentException {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        
        observers.add(observer);
    }
    
    /**
     *
     * @param observer
     */
    public void removeObserver(ITurnObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }
    
    /**
     *
     * @param observerId
     * @return the observer corresponding to the given ID (if found)
     */
    public Optional<ITurnObserver> findObserverById(int observerId) {
        return observers.stream()
                .filter(o -> o.getObserverId() == observerId)
                .findFirst();
    }
    
    /**
     * Notify all observers when a turn change occurs
     */
    protected void notifyObservers() {
        observers.stream().forEach((observer) -> { observer.notifyTurn(); });
    }
}

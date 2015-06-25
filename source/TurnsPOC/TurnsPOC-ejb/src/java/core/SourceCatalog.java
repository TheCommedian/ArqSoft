/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import common.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
public class SourceCatalog {

    private final List<TurnSource> turnSources;
    
    private SourceCatalog() {
        turnSources = new ArrayList<>();
    }
 
    private static class LazyHolder {
        private static final SourceCatalog INSTANCE = new SourceCatalog();
    }
 
    public static SourceCatalog getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * Get the value of turnSources
     *
     * @return the value of turnSources
     */
    public List<TurnSource> getTurnSources() {
        return turnSources;
    }

    public void addSource(TurnSource source) throws IllegalArgumentException {
        if (source == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        
        turnSources.add(source);
    }
    
    public void removeSource(TurnSource source) {
        if (source != null) {
            turnSources.remove(source);
        }
    }
    
    public Optional<TurnSource> findSourceById(int sourceId) {
        return turnSources.stream()
                .filter(s -> s.getSourceId() == sourceId)
                .findFirst();
    }
    
    public Optional<TurnSource> findSourceByDescription(String description) throws IllegalArgumentException {
        StringUtils.validateNotNullOrEmpty(description, "description");
        
        return turnSources.stream()
                .filter(s -> s.getDescription().equals(description))
                .findFirst();
    }
}

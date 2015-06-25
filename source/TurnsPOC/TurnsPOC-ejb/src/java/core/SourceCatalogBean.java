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
import javax.ejb.Singleton;
import javax.jws.WebService;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */

@WebService(serviceName = "arqSoft.services")
@Singleton
public class SourceCatalogBean implements SourceCatalogBeanLocal, SourceCatalogBeanRemote {

    private final List<TurnSource> turnSources;

    public SourceCatalogBean() {
        turnSources = new ArrayList<>();
    }
 
    /**
     * Get the value of turnSources
     *
     * @return the value of turnSources
     */
    @Override
    public List<TurnSource> getTurnSources() {
        return turnSources;
    }

    @Override
    public void addSource(TurnSource source) throws IllegalArgumentException {
        //TODO cambiar tipo de retorno
        if (source == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        
        turnSources.add(source);
    }
    
    @Override
    public void removeSource(TurnSource source) {
        if (source != null) {
            turnSources.remove(source);
        }
    }
    
    @Override
    public Optional<TurnSource> findSourceById(int sourceId) {
        return turnSources.stream()
                .filter(s -> s.getSourceId() == sourceId)
                .findFirst();
    }
    
    @Override
    public Optional<TurnSource> findSourceByIdLocal(int sourceId) {
        return this.findSourceById(sourceId);
    }
    
    @Override
    public Optional<TurnSource> findSourceByDescription(String description) throws IllegalArgumentException {
        StringUtils.validateNotNullOrEmpty(description, "description");
        
        return turnSources.stream()
                .filter(s -> s.getDescription().equals(description))
                .findFirst();
    }
}

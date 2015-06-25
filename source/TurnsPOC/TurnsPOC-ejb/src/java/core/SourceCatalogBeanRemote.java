/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.List;
import java.util.Optional;
import javax.ejb.Remote;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Remote
public interface SourceCatalogBeanRemote {
    List<TurnSource> getTurnSources();
    
    void addSource(TurnSource source) throws IllegalArgumentException;
    
    void removeSource(TurnSource source);
    
    Optional<TurnSource> findSourceById(int sourceId);
    
    Optional<TurnSource> findSourceByDescription(String description) throws IllegalArgumentException;
}

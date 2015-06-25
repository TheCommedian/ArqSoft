/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.Optional;
import javax.ejb.Local;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 */
@Local
public interface SourceCatalogBeanLocal {
    
    Optional<TurnSource> findSourceByIdLocal(int sourceId);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Marcelo Barberena / Fernando Maidana
 * 
 */

public class DataFacade {
    
    private static EntityManagerFactory emf;
        
    private DataFacade() {
        this.emf = javax.persistence.Persistence.createEntityManagerFactory("TurnsPOC-ejbPU");
    }
    
    public static Long create(BaseEntity entity) {
        EntityManager em = emf.createEntityManager();
        Long id;
        em.getTransaction().begin();
        try {
            em.persist(entity);
            em.getTransaction().commit();
            id = entity.id;
        } catch (Exception e) {
            em.getTransaction().rollback();
            id = 0L;
        } finally {
            em.close();
        }   
        return id;
    }
    
    public static void edit(BaseEntity entity) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {            
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();        
        } finally {
            em.close();
        }   
    }       
    
    public static List<UserEntity> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserEntity.class));
        Query query = em.createQuery(cq);   
        List<UserEntity> result = query.getResultList();
        em.close();
        return result;
    } 
    
    public static List<TurnSourceEntity> getAllTurnSources() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(TurnSourceEntity.class));
        Query query = em.createQuery(cq);   
        List<TurnSourceEntity> result = query.getResultList();
        em.close();
        return result;
    }  
}


/*************************************************************************
 * CONFIDENTIAL
 * __________________
 * [2013] - Yinsol - All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Yinsol and its suppliers, if any.  
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Yinsol.
 */
package com.yin.aip.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.yin.aip.util.JPAUtil;
  
/**
 * @author Ram Vanga
 *
 * @param <T>
 * 
 * Generic DAO
 */
abstract class GenericDAO<T> implements Serializable { 
  
	private static final long serialVersionUID = 1L; 
	//TODO make this (aip_core) configurable read from props 
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("aip_core"); 
    protected EntityManager em; 
    private Class<T> entityClass; 
  
    /**
     *  Constructor
     *  @param entityClass
     */
     public GenericDAO(Class<T> entityClass) { 
     	this.entityClass = entityClass; 
     } 
   
    /**
     * 
     */
    public void beginTransaction() { 
        em = JPAUtil.getInstance().getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin(); 
    } 
  
    /**
     * 
     */
    public void commit() { 
        em.getTransaction().commit(); 
    } 
  
    /**
     * 
     */
    public void rollback() { 
        em.getTransaction().rollback(); 
    } 
   
    /**
     * 
     */
    public void closeTransaction() { 
        em.close(); 
    } 
  
    /**
     * 
     */
    public void commitAndCloseTransaction() { 
        commit(); 
        closeTransaction(); 
    } 
  
    /**
     * 
     */
    public void flush() { 
        em.flush(); 
    } 
  
    /**
     * 
     */
    public void joinTransaction() { 
        em = emf.createEntityManager(); 
        em.joinTransaction(); 
    } 
  
    /**
     * @param entity
     */
    public void save(T entity) { 
        em.persist(entity);
        em.flush();
    } 
  
    /**
     * @param id
     * @param classe
     */
    protected void delete(Object id, Class<T> classe) { 
        T entityToBeRemoved = em.getReference(classe, id); 
  
        em.remove(entityToBeRemoved); 
    } 
  
    /**
     * @param entity
     * @return
     */
    public T update(T entity) { 
        return em.merge(entity); 
    } 
  
    /**
     * @param entityID
     * @return
     */
    public T find(int entityID) { 
        return em.find(entityClass, entityID); 
    } 
  
    /**
     * @param entityID
     * @return
     */
    public T findReferenceOnly(int entityID) { 
        return em.getReference(entityClass, entityID); 
    } 
  
    
 // Using the unchecked because JPA does not have a 
    // em.getCriteriaBuilder().createQuery()<T> method 
    /**
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" }) 
    public List<T> findAllWhere(String column,String value) { 
    	CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(); 
        Root entityRoot = cq.from(entityClass);
        cq.select(entityRoot);
        //ParameterExpression<String> p = builder.parameter(String.class);
        cq.where(builder.equal(entityRoot.get(column), value));
        
        return em.createQuery(cq).getResultList(); 
    } 
  
    
    // Using the unchecked because JPA does not have a 
    // em.getCriteriaBuilder().createQuery()<T> method 
    /**
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" }) 
    public List<T> findAll() { 
    	CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(); 
        Root entityRoot = cq.from(entityClass);
        cq.select(entityRoot);
        return em.createQuery(cq).getResultList(); 
    } 
  
    // Using the unchecked because JPA does not have a 
    // em.getCriteriaBuilder().createQuery()<T> method 
    /**
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" }) 
    public List<T> findAllSorted(String sortCol) { 
    	CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(); 
        Root entityRoot = cq.from(entityClass);
        
        cq.select(entityRoot);
        cq.orderBy(builder.desc(entityRoot.get(sortCol)));
        return em.createQuery(cq).getResultList(); 
    } 
    
    // Using the unchecked because JPA does not have a 
    // query.getSingleResult()<T> method 
    /**
     * @param namedQuery
     * @param parameters
     * @return
     */
    @SuppressWarnings("unchecked") 
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) { 
        T result = null; 
  
        try { 
            Query query = em.createNamedQuery(namedQuery); 
  
            // Method that will populate parameters if they are passed not null and empty 
            if (parameters != null && !parameters.isEmpty()) { 
                populateQueryParameters(query, parameters); 
            } 
  
            result = (T) query.getSingleResult(); 
  
        } catch (NoResultException e) { 
        	//TODO throw e
        	System.out.println("No result found for named query: " + namedQuery); 
        } catch (Exception e) { 
            System.out.println("Error while running query: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
  
        return result; 
    } 
  
    /**
     * @param query
     * @param parameters
     */
    protected void populateQueryParameters(Query query, Map<String, Object> parameters) { 
        for (Entry<String, Object> entry : parameters.entrySet()) { 
            query.setParameter(entry.getKey(), entry.getValue()); 
        } 
    } 
}
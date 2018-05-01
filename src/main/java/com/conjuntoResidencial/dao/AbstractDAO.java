/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author Julian Olarte Torres
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractDAO<T, PK> {

    private final EntityManager entityManager;
    
    private final Class<T> persistentClass;
    
    public AbstractDAO(Class<T> persistentClass){ 
        //this.persistentClass =(Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.persistentClass = persistentClass;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conjuntoResidencial");
        EntityManager em = emf.createEntityManager();
        this.entityManager = em;
    }
    
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
     
    public T findAll() {
        return (T) this.getEntityManager()
                .createQuery(String.format("SELECT t FROM %s t", persistentClass.getName()), persistentClass)
                .getResultList();
    }
    
    public T findLast() {
         return (T) this.getEntityManager()
                .createQuery(String.format("SELECT t FROM %s t ORDER BY id DESC", persistentClass.getName()), persistentClass)
                .setMaxResults(1)
                .getSingleResult();
    }
    
    public T findByKey(PK key) {
        return (T) this.getEntityManager().find(persistentClass, key);
    }
    
    public T findAllByProperty(String propertyName, PK property) {
        return (T) this.getEntityManager()
                .createQuery(String.format("SELECT t FROM %s t WHERE t.%s = %s", persistentClass.getName(), propertyName, property), persistentClass)
                .getResultList();
    }
 
    public void save(T entity) {
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().merge(entity);
        this.getEntityManager().getTransaction().commit();
    }
    
    public T update( T entity ){
        this.getEntityManager().merge(entity);
        return entity;
   }
 
    public void delete(T entity) {
        this.getEntityManager().remove(entity);
    }
    
    public void deleteByKey(PK key) {
        this.getEntityManager().remove( this.getEntityManager().merge(this.findByKey(key)) );
        this.getEntityManager().flush();
    }
     
    protected CriteriaBuilder createEntityCriteria(){
        return this.getEntityManager().getCriteriaBuilder();
    }
    
}

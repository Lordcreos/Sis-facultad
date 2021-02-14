package com.uisrael.complementario.modelo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.uisrael.complementario.modelo.dao.IGenericDao;

public class GenericDaoImpl<T> implements IGenericDao<T>{

	private Class<T> entityClass;
    
	    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("complementario_PU");
	    protected EntityManager entityManager;
	
	    // Constructor
	    public GenericDaoImpl(){
	        entityManager = emf.createEntityManager(); // Crear conexión
	    }
	    
	    // Sobrecarga del Constructor, crear el objecto para su uso si se necesita
	    public GenericDaoImpl(Class<T> entityClass){
	        this.entityClass = entityClass;
	        entityManager = emf.createEntityManager();
	    }
	    
	    /**
	     * Definimos el CRUD
	     * 
	     * @param t Tipo
	     * @return el tipo
	     */
	    public T create(T t){
	        this.entityManager.persist(t);
	        return t;
	    }
	    
	    public T read (Object id){
	        return this.entityManager.find(entityClass, id);
	    }
	    
	    public T update (T t){
	        return this.entityManager.merge(t);
	    }
	    
	    public void delete(T t){
	        t = this.entityManager.merge(t);
	        this.entityManager.remove(t);
	    }
	    
	    
	    //Definir los parámetros
	    public void beginTransaction(){
	        if(!entityManager.getTransaction().isActive()) // Existe conexión activa?
	            entityManager = emf.createEntityManager(); // Crear conexión
	        
	        entityManager.getTransaction().begin(); // Inicializar transacción
	    }
	    
	    public void commit(){
	        if(entityManager.getTransaction().isActive())
	            entityManager.getTransaction().commit();
	    }
	    
	    public void rollback(){
	         if(entityManager.getTransaction().isActive())
	            entityManager.getTransaction().rollback();
	    }
	    
	    public void closeTransaction(){
	        entityManager.close();
	    }
	    
	    public void commitAndCloseTransaction(){
	        commit();
	        closeTransaction();
	    }
	    
	    public void flush(){
	        entityManager.flush();
	    }
	    
	    public List<T> findAll(){
	        javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
	        cq.select(cq.from(entityClass));
	        return this.entityManager.createQuery(cq).getResultList();
	    }
		
}

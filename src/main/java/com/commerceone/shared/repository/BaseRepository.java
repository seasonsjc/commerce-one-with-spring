package com.commerceone.shared.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseRepository<Entity extends Serializable
									, Id extends Serializable> {
	
	private EntityManagerFactory emf;
	
	private Class<Entity> clazz;
	
	public BaseRepository(Class<Entity> clazz) {
		emf = Persistence.createEntityManagerFactory("commerceOnePU");
		this.clazz = clazz;
	}
	
	public Entity create (Entity entity) {
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
		
		return entity;
		
	}
	
	public Entity findById (Id id) {
		
		EntityManager em = emf.createEntityManager();
		Entity entity = em.find(clazz, id);
		em.close();
		return entity;
		
	}
	
	
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}

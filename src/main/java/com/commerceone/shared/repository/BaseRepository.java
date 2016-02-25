package com.commerceone.shared.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


public abstract class BaseRepository<Entity extends Serializable
									, Id extends Serializable> {
	
	@PersistenceContext
	private EntityManager em;
	
	private Class<Entity> clazz;
	
	public BaseRepository() {
		clazz = getParametrizedType();
	}
	
	public BaseRepository(Class<Entity> clazz) {
		this.clazz = clazz;
	}
	
	@Transactional
	public Entity create (Entity entity) {
		em.persist(entity);
		return entity;
	}
	
	@Transactional(readOnly=true)
	public Entity findById (Id id) {
		Entity entity = em.find(clazz, id);
		return entity;
	}

	public Class<Entity> getParametrizedType() {

		ParameterizedType type = (ParameterizedType) getClass()
				.getGenericSuperclass();

		Type t = type.getActualTypeArguments()[0];

		return (Class<Entity>) t;

	}
	
}

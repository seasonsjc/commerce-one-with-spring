package com.commerceone.catalog;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CatalogRepository {
	
	
	private EntityManagerFactory emf;
	
	public CatalogRepository() {
		emf = Persistence.createEntityManagerFactory("commerceOnePU");
	}
	
	public void create (Catalog catalog) {
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(catalog);
		em.getTransaction().commit();
		em.close();
				
	}

	public void update (Catalog catalog) {
		
	}
	
	public Catalog findById (Long id) {
		EntityManager em = emf.createEntityManager();
		Catalog catalog = em.find(Catalog.class, id);
		em.close();
		return catalog;
	}

	public List<Catalog> findAll () {
		return null;
	}
	
	public void delete (Long id) {
		
	}
	
	
	
	
	
	

}

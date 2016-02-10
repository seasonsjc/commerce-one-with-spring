package com.commerceone.catalog;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CatalogRepositoryTest {

	
	@Test
	public void createNewCatalogSuccessfully () {
		
		
		Catalog catalog = new Catalog();
		catalog.setName("TV");
		catalog.setType("Eletronicos");
		
		
		CatalogRepository repository 
				= new CatalogRepository();
		repository.create(catalog);
		
		Assert.assertNotNull(catalog.getId());
		
		
	}
	
	@Test
	public void findValidCatalog () {
		
		CatalogRepository repository 
		= new CatalogRepository();

		Catalog catalog = new Catalog();
		catalog.setName("TV");
		catalog.setType("Eletronicos");
		
		repository.create(catalog);
		
		
		Catalog storedCatalog = repository.findById(catalog.getId());
		
		Assert.assertNotNull(storedCatalog);
		Assert.assertEquals(catalog
							, storedCatalog);
		
		
		
	}
	
	public static void main(String[] args) {
		
		CatalogRepositoryTest test = new CatalogRepositoryTest();
		test.createNewCatalogSuccessfully();
		
	}
	
	
}

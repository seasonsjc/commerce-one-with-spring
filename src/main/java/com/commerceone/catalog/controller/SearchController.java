package com.commerceone.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.commerceone.catalog.Product;

@ManagedBean
@ViewScoped
public class SearchController {

	private static final Logger logger = Logger.getLogger(SearchController.class);
	
	private List<Product> items;
	
	public SearchController() {
		logger.debug("SearchController criado .. ");
		loadItems();
	}
	
	public List<Product> getItems() {
		
		logger.debug("Acessando o get Items.. ");
		
		return items;
	}
	
	public void addToShoppingCart(Product product) {
		
		logger.debug(product);
		
	}
	
	
	
	private void loadItems () {
		items = new ArrayList<Product>();
		
		for (int i = 0; i < 20; i++) {
			items.add ( new Product( "Product - " + i
									, ( i + 1 * 1.2 )
									, "Mega Product " + i)  );
		}
	}
	 
	
	
	 
}



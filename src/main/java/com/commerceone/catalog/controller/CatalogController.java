package com.commerceone.catalog.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commerceone.catalog.Catalog;

@RestController
public class CatalogController {
	
	
	@RequestMapping(name="/catalog/publish",method=RequestMethod.GET)
	public Catalog publish(@RequestBody Catalog catalog  ) { 
		System.out.println(catalog);
		return catalog;
	}

}

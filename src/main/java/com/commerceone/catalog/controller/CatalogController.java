package com.commerceone.catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.commerceone.catalog.Catalog;

@Controller
public class CatalogController {
	
	
	@RequestMapping(name="/catalog/publish",method=RequestMethod.GET)
	public String publish(@RequestParam Catalog catalog  ) { 
		System.out.println(catalog);
		return "publish";
	}

}

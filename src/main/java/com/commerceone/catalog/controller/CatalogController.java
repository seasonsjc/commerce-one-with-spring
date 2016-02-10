package com.commerceone.catalog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.commerceone.catalog.Catalog;

@Controller
public class CatalogController {
	

	
	@RequestMapping(value="/catalog/new",method=RequestMethod.GET)
	public String addForm() {
		return "/catalog/new";
	}

	
	@RequestMapping(value="/catalog/add",method=RequestMethod.POST)
	public String add(Catalog catalog) {
		return "/catalog/add";
	}
	
	@RequestMapping(value="/catalog/list",method=RequestMethod.GET)
	public String list() {
		return "list";
	}
	
	@RequestMapping(value="/catalog/publish",method=RequestMethod.GET)
	public ModelAndView publish(@RequestBody Catalog catalog  ) { 
		System.out.println(catalog);
		
		ModelAndView view = new ModelAndView();
		view.addObject("catalog", catalog);
		return  view;
	}

}

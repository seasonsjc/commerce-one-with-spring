package com.commerceone.sales;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import junit.framework.Assert;

public class CreateSalesOrderControllerTest {
	
	@InjectMocks
	private CreateSalesOrderController controller;
	
	@Mock
	private OrderService service;
	
	@Mock
	private OrderRepository repository;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void givenInstanceOfControllerThenCallAllMethod () {
		
		List<Order> expected = OrderFixtureFactory.newOrders();
		
		Mockito.when( service.getAll() ).thenReturn(repository);
		Mockito.when( repository.findAll() ).thenReturn(expected);
		
		List<Order> orders = controller.all();
		Assert.assertEquals( expected ,  orders);
	}
	
	@Test
	public void givenRequestForAllOrdersThenReturnListOfOrders() throws Exception {
		
		List<Order> expected = OrderFixtureFactory.newOrders();
		
		Mockito.when( service.getAll() ).thenReturn(repository);
		Mockito.when( repository.findAll() ).thenReturn(expected);		
		
		MvcResult result = 	mockMvc.perform( get("/api/orders/all")  )
									.andDo( print())
									.andExpect( status().isOk() )
									.andExpect( content().contentType(MediaType.APPLICATION_JSON)  )
									.andReturn();
		
	
		
		
	}
	
	
}

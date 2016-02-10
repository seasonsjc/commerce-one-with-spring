package com.commerceone.identity;

public class UserTest {
	
	
	public void createNewUserTest() {
		
		User user = new User();
		user.setName("Ze das Cove");
		Login login = new Login();
		login.setPassoword("1234");
		login.setUsername("ze.cove");
		user.setLogin(login);
		
		
		
	}

}

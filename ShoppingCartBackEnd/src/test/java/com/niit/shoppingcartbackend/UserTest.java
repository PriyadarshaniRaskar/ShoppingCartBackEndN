package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.model.User;

public class UserTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();

		User user = (User) context.getBean("user");
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");

		user.setId("U104");
		user.setName("Lehenga");
		user.setPassword("Pritii");
		
		userDAO.saveOrUpdate(user);

		System.out.println(userDAO.listUser());
	}
}

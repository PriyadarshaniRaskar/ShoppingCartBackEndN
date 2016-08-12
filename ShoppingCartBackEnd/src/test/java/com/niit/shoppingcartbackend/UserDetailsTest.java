package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDetailsDAO;
import com.niit.shoppingcartbackend.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();

		UserDetails userDetails = (UserDetails) context.getBean("userDetails");
		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");

		userDetails.setUserId("U1011");
		userDetails.setUserName("Sara");
		userDetails.setPassword("sara111");
		userDetails.setMobile("9862536421");
		userDetails.setEmail("sara@1295");
		userDetails.setAddress("Mumbai");
		
		
		userDetailsDAO.saveOrUpdate(userDetails);

		System.out.println(userDetailsDAO.listUserDetails());
	}
}

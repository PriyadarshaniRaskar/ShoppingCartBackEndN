package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CartDAO;
import com.niit.shoppingcartbackend.model.Cart;

public class CartTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();

		Cart cart = (Cart) context.getBean("cart");
		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");

		cart.setCartProductId("Cart04");
		cart.setCartProductName("Lehenga");
		cart.setCartProductUser("Smruti");
		cart.setCartProductPrice(4999);

		cartDAO.saveOrUpdate(cart);

		System.out.println(cartDAO.listCart());
	}
}

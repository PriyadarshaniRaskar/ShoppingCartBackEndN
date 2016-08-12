package com.niit.shoppingcartbackend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.model.Product;

public class ProductTest {
	
public static void main(String[] args){
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.niit.shoppingcartbackend");
	context.refresh();
	
	ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
	Product product = (Product) context.getBean("product");
	
	
	product.setId("P110");
	product.setName("Watches");
	product.setDescription("A");
	product.setPrice(1999);
	product.setQuantity(2);
	product.setSupplierid("S115");
	product.setCategoryid("Cat116");
	


	productDAO.saveOrUpdate(product);
	
}
}


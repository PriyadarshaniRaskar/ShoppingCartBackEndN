package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.model.Supplier;

public class SupplierTest {
	
public static void main(String[] args){
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.niit.shoppingcartbackend");
	
	context.refresh();
	
	SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	Supplier supplier = (Supplier) context.getBean("supplier");
	
	supplier.setId("S104");
	supplier.setName("Ethnica Arts");
	supplier.setAddress("Pune");
	supplier.setEmail("arts@123");
	supplier.setContactno("9856234125");



	supplierDAO.saveOrUpdate(supplier);
	/*supplierDAO.delete("CG120");*/
}
}

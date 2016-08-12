package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component("category")
public class Category {
	@Id
	private String Id;
	private String name;
	private String description;
	private String SupplierId;
	private String ProductId;

	
	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;

	}

	public String getSupplierId() {
		return SupplierId;
	}

	public void setSupplierId(String supplierId) {
		this.SupplierId = supplierId;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		this.ProductId = productId;
	}

}

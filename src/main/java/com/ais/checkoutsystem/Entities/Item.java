package com.ais.checkoutsystem.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="product_id")
	private long productId;
	
	private String user;
	
	@Min(value = 1, message = "quantity must be greater than zero")
	private int quantity;
	
	@Column(name="in_cart")
	private boolean inCart;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isInCart() {
		return inCart;
	}

	public void setInCart(boolean inCart) {
		this.inCart = inCart;
	}
		
}

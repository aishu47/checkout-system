package com.ais.checkoutsystem.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	
	@Column(name = "is_special_offer")
	private boolean isSpecialOffer;
	
	@Column(name = "offer_quantity")
	private int offerQuantity;
	
	@Column(name="offer_price")
	private double offerPrice;
	
	@Column(name = "created_date")
    private Date createdDate;
	
	public Product() {
		
	}
	public Product(long id, String name, double price, boolean isSpecialOffer, int offerQuantity, Double offerPrice,  Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isSpecialOffer = isSpecialOffer;
		this.offerQuantity = offerQuantity;
		this.offerPrice = offerPrice;
		this.createdDate = createdDate;
	}

	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}	

	public boolean getIsSpecialOffer() {
		return isSpecialOffer;
	}
	
	public int getOfferQuantity() {
		return offerQuantity;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}	
	
}

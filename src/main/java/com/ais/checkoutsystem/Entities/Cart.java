package com.ais.checkoutsystem.Entities;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	
	private List<Item> items;
	private double totalAmount;
	private double discountPrice;
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	@Override
	public String toString() {
		return "Cart [items=" + items + ", totalAmount=" + totalAmount + ", discountPrice=" + discountPrice + "]";
	}
	
	
}

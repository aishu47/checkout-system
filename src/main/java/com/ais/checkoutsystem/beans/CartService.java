package com.ais.checkoutsystem.beans;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ais.checkoutsystem.Entities.Cart;
import com.ais.checkoutsystem.Entities.Item;
import com.ais.checkoutsystem.Entities.Product;
import com.ais.checkoutsystem.repo.ItemRepo;
import com.ais.checkoutsystem.repo.ProductRepo;

@Component
public class CartService {
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	public Cart getCartDetails(String user) {
		Cart cart = null;
		List<Item> items = itemRepo.findByUserAndInCart(user, true);
		double totalPrice = 0;
		double discountPrice = 0;

		for(Item item : items) {
			Optional<Product> productOpt = productRepo.findById(item.getProductId());
			if(productOpt.isPresent()) {
				Product product = productOpt.get();
				totalPrice +=product.getPrice()*item.getQuantity();
				if(product.getIsSpecialOffer()) {
					int offerQuantity = product.getOfferQuantity();
					discountPrice +=item.getQuantity()/offerQuantity*product.getOfferPrice();
					discountPrice +=item.getQuantity()%offerQuantity*product.getPrice();
				}else {
					discountPrice +=item.getQuantity()*product.getPrice();
				}
				
			}
				
			
		}
		if(items.size()>0) {
			cart = new Cart();
			cart.setItems(items);
			cart.setTotalAmount(totalPrice);
			cart.setDiscountPrice(discountPrice);
		}
		return cart;
	}
	
	public void updateCart(Item item) throws Exception {
		Optional<Product> product = productRepo.findById(item.getProductId());
		if(product.isEmpty())
			throw new Exception("Product Not available for Id "+item.getProductId());
		
		item.setInCart(true);
		Optional<Item> dbItem = itemRepo.findByProductIdAndUserAndInCart(item.getProductId(), item.getUser(),true);
		if(dbItem.isPresent()) {
			Item updateItem = dbItem.get();
			updateItem.setQuantity(updateItem.getQuantity()+item.getQuantity());
			itemRepo.save(updateItem);
		}else		
		itemRepo.save(item);
		  
	}
	

}

package com.ais.checkoutsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ais.checkoutsystem.Entities.Cart;
import com.ais.checkoutsystem.Entities.Item;
import com.ais.checkoutsystem.beans.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	

	@GetMapping("/{user}")
	public ResponseEntity<Cart> viewCart(@PathVariable String user) {
		Cart cart = cartService.getCartDetails(user);
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Item> addToCart(@RequestBody Item item) throws Exception {
		cartService.updateCart(item);
		return new ResponseEntity<Item>(item,HttpStatus.CREATED);
	}

}

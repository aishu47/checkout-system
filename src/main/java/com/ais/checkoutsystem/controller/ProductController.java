package com.ais.checkoutsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ais.checkoutsystem.Entities.Product;
import com.ais.checkoutsystem.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepo productRepo;

	@GetMapping
	public List<Product> retreiveAll(){
		return productRepo.findAll();
	} 
	
	@GetMapping("/{id}")
	public Optional<Product> findProduct(@PathVariable long id){
		System.out.println(id);
		return productRepo.findById(id);
	} 
}

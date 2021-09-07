package com.ais.checkoutsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ais.checkoutsystem.Entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
	
}

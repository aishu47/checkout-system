package com.ais.checkoutsystem.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ais.checkoutsystem.Entities.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {
	public List<Item> findByUserAndInCart(String user, boolean inCart);
	public Optional<Item> findByProductIdAndUserAndInCart(Long productId, String user, boolean inCart); 
}

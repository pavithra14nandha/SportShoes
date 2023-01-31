package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	String query="select product.price from Product product where product.pid=?1";
	
	@Query(query)
	public Float findprice(int id);
}
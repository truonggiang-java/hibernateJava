package com.example.hibernate.repository;

import java.util.List;

import com.example.hibernate.entity.Product;

public interface ProductRepository {
	List<Product> findAllProduct();
	Product findById(Integer id);
	void insert(Product p);
	void update(Product p);
}

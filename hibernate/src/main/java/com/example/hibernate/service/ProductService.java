package com.example.hibernate.service;

import java.util.List;

import com.example.hibernate.entity.Brand;
import com.example.hibernate.entity.Product;

public interface ProductService {
	List<Product> findAllProduct();
	Product findById(Integer id);
	void insert(Product p);
	void update(Product p);
}

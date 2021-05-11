package com.example.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.entity.Product;
import com.example.hibernate.repository.ProductRepository;
import com.example.hibernate.service.ProductService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Override
	public void insert(Product p) {
		productRepository.insert(p);
		
	}
	@Override
	public List<Product> findAllProduct() {
		
		return productRepository.findAllProduct();
	}
	@Override
	public Product findById(Integer id) {
		return productRepository.findById(id);
	}
	
	@Override
	public void update(Product p) {
		productRepository.update(p);
	}
	
}

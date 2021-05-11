package com.example.hibernate.service;

import java.util.List;

import com.example.hibernate.entity.Brand;

public interface BrandService {
	List<Brand> findAllBrand();
	Brand findById(Integer id);
	void insert(Brand b);
	void update(Brand b);
	void delete(Integer id);
}

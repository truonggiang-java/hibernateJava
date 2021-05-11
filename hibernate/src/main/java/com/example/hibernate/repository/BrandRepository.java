package com.example.hibernate.repository;

import java.util.List;

import com.example.hibernate.entity.Brand;

public interface BrandRepository {
	List<Brand> findAllBrand();
	Brand findById(Integer id);
	void insert(Brand b);
	void update(Brand b);
	void delete(Brand b);
}

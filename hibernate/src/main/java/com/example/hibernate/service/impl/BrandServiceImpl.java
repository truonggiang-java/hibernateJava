package com.example.hibernate.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernate.entity.Brand;
import com.example.hibernate.repository.BrandRepository;
import com.example.hibernate.service.BrandService;

@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;
	
	
	
	@Override
	public void insert(Brand b) {
		brandRepository.insert(b);
	}



	@Override
	public void update(Brand b) {
		brandRepository.update(b);
	}



	@Override
	public void delete(Integer id) {
		Brand b=brandRepository.findById(id);
		brandRepository.delete(b);
	}



	@Override
	public Brand findById(Integer id) {
		return brandRepository.findById(id);
	}



	@Override
	public List<Brand> findAllBrand() {
		
		return brandRepository.findAllBrand();
	}
	
	
}

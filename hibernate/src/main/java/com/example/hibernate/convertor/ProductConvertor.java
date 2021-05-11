package com.example.hibernate.convertor;

import org.springframework.stereotype.Component;

import com.example.hibernate.dto.ProductDto;
import com.example.hibernate.entity.Brand;
import com.example.hibernate.entity.Product;

@Component
public class ProductConvertor {
	public Product convertor(ProductDto productDto,Integer id) {
		Product product=new Product();
		Brand brand=new Brand();
		if(id != null) {
			product.setId(id);
		}
		else {
			product.setId(null);
		}
		product.setName(productDto.getName());
		product.setDesciption(productDto.getDescription());
		product.setDiscount(productDto.getDiscount());
		product.setStatus(productDto.isStatus());
		brand.setId(productDto.getBrand());
		product.setBrand(brand);
		return product;
	}
}

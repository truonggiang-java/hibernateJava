package com.example.hibernate.convertor;

import org.springframework.stereotype.Component;

import com.example.hibernate.dto.BrandDto;
import com.example.hibernate.entity.Brand;

@Component
public class BrandConvertor {
	public Brand convertor(BrandDto brandDto,Integer id) {
		Brand brand=new Brand();
		if(id != null) {
			brand.setId(id);
		}
		else {
			brand.setId(null);
		}
		brand.setName(brandDto.getName());
		brand.setSlug(brandDto.getSlug());
		brand.setStatus(brandDto.getStatus());
		return brand;
	}
}

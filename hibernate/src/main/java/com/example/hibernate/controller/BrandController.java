package com.example.hibernate.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.convertor.BrandConvertor;
import com.example.hibernate.dto.BrandDto;
import com.example.hibernate.entity.Brand;
import com.example.hibernate.service.BrandService;

@RestController
@RequestMapping("/brands")
@CrossOrigin(origins = "http://127.0.0.1:5500",maxAge = 3600)
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@GetMapping
	public ResponseEntity<Object> findAllBrand(){
		return new ResponseEntity<>(brandService.findAllBrand(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(brandService.findById(id), HttpStatus.OK);
	}
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody BrandDto brandDto){
		BrandConvertor brandConvertor=new BrandConvertor();
		Brand b=brandConvertor.convertor(brandDto, brandDto.getId());
		brandService.insert(b);
		return new ResponseEntity<>("Thêm mới thành công",HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@RequestBody BrandDto brandDto,@PathVariable("id") Integer id){
		BrandConvertor brandConvertor=new BrandConvertor();
		Brand b=brandConvertor.convertor(brandDto, id);
		brandService.update(b);
		return new ResponseEntity<>("Cập nhập thành công", HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		brandService.delete(id);
		return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
	}
	
}

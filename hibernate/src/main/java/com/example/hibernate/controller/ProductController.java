package com.example.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate.convertor.ProductConvertor;
import com.example.hibernate.dto.ProductDto;
import com.example.hibernate.entity.Product;
import com.example.hibernate.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/insert")
	public ResponseEntity<Object> insert(@RequestBody ProductDto productDto){
		ProductConvertor productConvertor=new ProductConvertor();
		Product product=productConvertor.convertor(productDto,productDto.getId());
		productService.insert(product);
		return new ResponseEntity("Thêm mới thành công", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@RequestBody ProductDto productDto,@PathVariable("id")Integer id){
		ProductConvertor productConvertor=new ProductConvertor();
		Product product=productConvertor.convertor(productDto,id);
		productService.update(product);
		return new ResponseEntity("Cập nhập thành công", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Object> findAllProduct(){
		return new ResponseEntity<>(productService.findAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
	}
}

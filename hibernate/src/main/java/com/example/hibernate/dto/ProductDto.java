package com.example.hibernate.dto;

public class ProductDto {
	private Integer id;
	private String name;
	private String description;
	private Double discount;
	private Integer brand;
	private boolean status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getBrand() {
		return brand;
	}
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ProductDto(Integer id, String name, String description, Double discount, Integer brand, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.discount = discount;
		this.brand = brand;
		this.status = status;
	}
	public ProductDto() {
		super();
	}
	
	
}

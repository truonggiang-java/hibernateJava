package com.example.hibernate.dto;

public class BrandDto {
	private Integer id;
	private String name;
	private String slug;
	private Boolean status;
	
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
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public BrandDto(Integer id, String name, String slug, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.status = status;
	}
	
	
}

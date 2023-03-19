package com.nimap.catogery_product.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
	@Id
	private int id;
	private String product;
	private double price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Category category;
	
	@JsonIgnore
	public Category getCategory() {
		return category;
	}
	@JsonProperty
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}

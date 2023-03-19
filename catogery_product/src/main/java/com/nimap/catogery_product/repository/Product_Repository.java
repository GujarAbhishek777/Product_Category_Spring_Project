package com.nimap.catogery_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.catogery_product.dto.Product;
public interface Product_Repository extends JpaRepository<Product, Integer> {

}

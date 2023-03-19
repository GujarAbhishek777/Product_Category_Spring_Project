package com.nimap.catogery_product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.catogery_product.dao.Catogery_Product_Dao;
import com.nimap.catogery_product.dto.Category;
import com.nimap.catogery_product.dto.Product;

@RestController
public class Category_Product_Controller {
	
	@Autowired
	Catogery_Product_Dao dao;
	
	//CREATE CATEGORY
	@PostMapping("api/categories")
	public Category saveCatogery(@RequestBody Category category) {
		 return dao.saveCategory(category);
	}
	//GET ALL CATEGORY
	@GetMapping("api/categories/page")
	public List<Category> getAllCategory(
			@RequestParam(value = "pagenumber",defaultValue="0", required=false)Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "2",required = false)Integer pagesize
			){
		return dao.getAllCategory(pagenumber,pagesize);
	}
	//GET CATEGORY BY ID
	@GetMapping("api/categories/{di}")
	public Optional<Category> getById(@PathVariable("id")int id) {
		return dao.getCategoryById(id);
	}
	
	//UPDATE CATEGORY BY ID
	@PutMapping("api/categories/{di}")
	public Category updateCategory(@RequestBody Category category,@PathVariable("id") int id) {
		return dao.updateCategory(category,id);
	}
	//DELETE CATEGORY BY ID
	@DeleteMapping("api/categories/{di}")
	public void deleteById(@PathVariable("id") int id) {
		dao.deleteCategory(id);
	}
	
	//CREATE PRODUCT
	@PostMapping("api/products")
	public Product saveProduct(@RequestBody Product product) {
		return dao.saveProduct(product);
	}
	
	//GET ALL PRODUCT
	@GetMapping("api/products/page")
	public List<Product> getAllProduct(
			@RequestParam(value = "pagenumber",defaultValue="0", required=false)Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "2",required = false)Integer pagesize
			) {
		return dao.getAllProduct(pagenumber,pagesize);
	}
	
	//GET BY ID
	@GetMapping("api/products/{di}")
	public Optional<Product> getProductById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	//UPDATE PRODUCT BY ID
		@PutMapping("api/products/{di}")
		public Product updateProduct(@RequestBody Product products,@PathVariable("id") int id) {
			return dao.updateproduct(products,id);

	}
		//DELETE BY ID
		@DeleteMapping("api/products/{di}")
		public void deleteProductById(@PathVariable int id) {
			dao.deleteProductById(id);
		}
}

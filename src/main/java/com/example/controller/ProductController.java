package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping(value="/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Product> createStudents(@RequestBody Product product){
		int pro = productservice.insertProduct(product);
		if(pro == 0) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Product>( HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> listpro = productservice.getAllProduct();
		return new ResponseEntity<List<Product>>(listpro, HttpStatus.OK);
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product){
		int pro = productservice.updateProduct(product.getProductname(), product.getProductprice(), id);
		if(pro == 0) {
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@RequestMapping(value="/id/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Product> updateStudent(@PathVariable int id){
	int stu = productservice.deleteProduct(id);
	if(stu == 0) {
		return new ResponseEntity<Product> (HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Product> (HttpStatus.OK);
	}
}

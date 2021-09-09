package com.example.mapper;

import java.util.List;

import com.example.entity.Product;

public interface ProductMapper {
	
	List<Product> getAllProduct(); 
	int insertProduct(Product product);
	int updateProduct(String productname, String productprice, int productid);
	int deleteProduct(int productid);
	
}

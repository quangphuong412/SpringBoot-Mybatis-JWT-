package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;
import com.example.mapper.ProductMapper;

@Repository
public class ProductRepoImpl implements ProductRepo{
	
	@Autowired
	private ProductMapper productmapper;
	
	public List<Product> getAllProduct(){
		return productmapper.getAllProduct();
	}
	
	public int insertProduct(Product product) {
		return productmapper.insertProduct(product);
	}
	
	public int updateProduct(String productname, String productprice, int productid) {
		return productmapper.updateProduct(productname, productprice, productid);
	}
	
	public int deleteProduct(int productid) {
		return productmapper.deleteProduct(productid);
	}

}

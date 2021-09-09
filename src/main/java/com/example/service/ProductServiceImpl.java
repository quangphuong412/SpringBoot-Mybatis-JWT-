package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productrepo;
	
	public List<Product> getAllProduct(){
		return productrepo.getAllProduct();
	}
	
	public int insertProduct(Product product) {
		return productrepo.insertProduct(product);
	}
	
	public int updateProduct(String productname, String productprice, int productid) {
		return productrepo.updateProduct(productname, productprice, productid);
	}

	public int deleteProduct(int productid) {
		return productrepo.deleteProduct(productid);
	}
}

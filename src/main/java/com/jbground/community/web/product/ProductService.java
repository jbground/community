package com.jbground.community.web.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jbground.community.model.Product;
import com.jbground.community.web.product.dao.ProductDao;

@Service
public class ProductService {
	
	@Resource(type = ProductDao.class)
	private ProductDao productDao;
	
	public List<Product> getAllProductList() throws Exception {
		return productDao.getAllProductList();		
	}
}

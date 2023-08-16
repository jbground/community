package com.jbground.community.web.product;

import java.util.List;

import javax.annotation.Resource;

import com.jbground.community.model.Paging;
import com.jbground.community.web.product.dao.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jbground.community.model.Product;
import com.jbground.community.web.product.dao.ProductDao;

@Service
public class ProductService {
	
	@Resource(type = ProductDao.class)
	private ProductDao productDao;

	@Resource(type = ProductRepository.class)
	private ProductRepository productRepository;
	
	public List<Product> getAllProductList() throws Exception {
		return productDao.getAllProductList();		
	}
	
	public List<Product> getProductList(int pageNo) throws Exception {
		return productDao.getProductList(pageNo);		
	}
	
	public int getProductListCnt() {
		return productDao.getProductListCnt();
		
	}

	public Page<Product> getProductListByPage(Paging paging) {
		PageRequest page = PageRequest.of(paging.getPageNo(), paging.getPageSize());
		return productRepository.findAll(page);
	}
}

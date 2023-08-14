package com.jbground.community.web.product.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbground.community.config.AbstractMybatisMapper;
import com.jbground.community.model.Product;

@Repository
public class ProductDao extends AbstractMybatisMapper{
	public List<Product> getAllProductList() throws Exception{
		return selectList("product.selectAllProductList");
		
	}
	
	public List<Product> getProductList(int pageNo) throws Exception{
		return selectList("product.selectProductList", pageNo);
		
	}
	
	public int getProductListCnt() {		
		return selectOne("product.productListCnt");	
	}
}

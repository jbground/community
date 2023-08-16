package com.jbground.community.web.product;

import com.jbground.community.model.Paging;
import com.jbground.community.model.Product;
import com.jbground.community.web.account.AccountController;

import org.hibernate.annotations.MetaValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource(type = ProductService.class)
    private ProductService productService;

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public String productList(HttpServletRequest request, ModelMap model, @ModelAttribute Paging paging) throws Exception{
    	

    	// 전체 게시물 조회
    	List<Product> productList = productService.getProductList(paging.getPageNo());
    	
    	
    	// 전체 게시물 개수 
    	int productListCnt = productService.getProductListCnt();
    	
    	int totalPageCnt =  (int) Math.ceil(productListCnt / 5);
    	
    	paging.setTotalCnt(totalPageCnt);
    	
    	model.addAttribute("productList", productList); 
//    	model.addAttribute("listCnt", productListCnt);


        return "thymeleaf/product/product_list";
    }

    @RequestMapping(value = "/product/list2")
    public String productList(HttpServletRequest request, ModelMap model) throws Exception{
        return "thymeleaf/product/product_list2";
    }

    @RequestMapping(value = "/product/pagination", method = RequestMethod.GET)
    @ResponseBody
    public Page<Product> productPagination(@ModelAttribute Paging paging, HttpServletRequest request) throws Exception {
        return productService.getProductListByPage(paging);
    }
}

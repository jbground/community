package com.jbground.community.web.product;

import com.jbground.community.web.account.AccountController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource(type = ProductService.class)
    private ProductService productService;

    @RequestMapping(value = "/product/list")
    public String productList(HttpServletRequest request, ModelMap model) throws Exception{


        return "thymeleaf/product/product_list";
    }
}

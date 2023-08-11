package com.jbground.community.web.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 메인화면
 * main.do, index.do
 */
@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);



    @RequestMapping(value = "/main")
    public String index(HttpServletRequest request, ModelMap model) throws Exception {


        return "thymeleaf/index";
    }

}

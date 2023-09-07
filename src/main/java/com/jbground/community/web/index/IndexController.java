package com.jbground.community.web.index;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 메인화면
 * main.do, index.do
 */
@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource(type = IndexService.class)
    private IndexService indexService;
    
    @RequestMapping(value = "/main")
    public String index(HttpServletRequest request, ModelMap model) throws Exception {

    	HttpSession session = request.getSession();

    	boolean result = indexService.checkLogin(session);
    	
    
    	// 로그인, 로그아웃 버튼 
    	model.addAttribute("result", result);

	
        return "thymeleaf/index";
    }

}

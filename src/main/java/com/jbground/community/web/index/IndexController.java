package com.jbground.community.web.index;

import com.jbground.community.web.account.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 메인화면
 * main.do, index.do
 */
@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);



    @RequestMapping(value = "/index.do")
    public String index(HttpServletRequest request) throws Exception {



        return "thymeleaf/index";
    }
}

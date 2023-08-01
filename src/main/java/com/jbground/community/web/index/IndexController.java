package com.jbground.community.web.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 메인화면
 * main.do, index.do
 */
@Controller
public class IndexController {

    @RequestMapping(name = "/index.do")
    public String index(HttpServletRequest request) throws Exception {

        return "";
    }
}

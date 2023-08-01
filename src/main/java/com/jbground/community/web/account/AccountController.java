package com.jbground.community.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 로그인, 로그아웃, 회원가입 관련
 * login.do
 * register.do
 * logout.do
 */
@Controller
public class AccountController {

    @RequestMapping(name = "/login.do")
    public String login(HttpServletRequest request, ModelMap model) throws Exception {

        return "thymeleaf/login/login";
    }

    @RequestMapping(name = "/register.do")
    public String register(HttpServletRequest request, ModelMap model) throws Exception {

        return "thymeleaf/register/register";
    }
}

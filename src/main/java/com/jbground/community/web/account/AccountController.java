package com.jbground.community.web.account;

import com.jbground.community.model.Member;
import com.jbground.community.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 로그인, 로그아웃, 회원가입 관련
 * login.do
 * register.do
 * logout.do
 */
@Controller
public class AccountController {

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Resource(type = AccountService.class)
    private AccountService accountService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, ModelMap model) throws Exception {
        List<Member> all = accountService.getMembers();
        for (Member m : all) {
            logger.info(CommonUtil.findObjectAddress(m));
        }

        List<Member> all2 = accountService.getMembers2();
        for (Member m : all2) {
            logger.info(CommonUtil.findObjectAddress(m));
        }
        return "thymeleaf/login/login";
    }

    /**
     * 회원 가입
     */
    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request, ModelMap model) throws Exception {


        return "thymeleaf/register/register";
    }

}

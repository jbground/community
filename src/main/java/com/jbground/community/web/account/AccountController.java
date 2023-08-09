package com.jbground.community.web.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbground.community.model.Member;
import com.jbground.community.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource(type = ObjectMapper.class)
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, ModelMap model) throws Exception {
        List<Member> all = accountService.getMembers();
        for (Member m : all) {
            logger.info(Common.findObjectAddress(m));
        }

        List<Member> all2 = accountService.getMembers2();
        for (Member m : all2) {
            logger.info(Common.findObjectAddress(m));
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

    @RequestMapping(value = "/json/test", method = RequestMethod.GET)
    public Map<String, Object> test(HttpServletRequest request, ModelMap model){
        Map<String, Object> map = new HashMap<>();

        map.put("status", 0);

        //자바 오브젝트가 json 형식으로 변하는 이유는
        // WebMvcConfiguration.java 의 85번째 줄을 통해
        // java object 입력받는걸 ObjectMapper 로 json 형식으로 변형할 수 있도록 설정해주었기 때문
        return map;
    }

    @RequestMapping(value = "/json/test2", method = RequestMethod.GET)
    public void test2(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{

        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);

        response.getWriter().print(objectMapper.writeValueAsString(map));
    }
}

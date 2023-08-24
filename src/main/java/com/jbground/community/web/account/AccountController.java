package com.jbground.community.web.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbground.community.model.Address;
import com.jbground.community.model.Member;
import com.jbground.community.model.common.ResponseStatus;
import com.jbground.community.util.Common;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    private int seq = 0;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, ModelMap model) throws Exception {

        return "thymeleaf/login/login";
    }

    /**
     * 회원 가입
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
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
    
    @ResponseBody
    @RequestMapping(value = "/json/test2", method = RequestMethod.GET)
    public void test2(@RequestParam String id, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{

        Map<String, Object> map = new HashMap<>();
        
        int result = accountService.checkId(id);

        if(result == 1) {
        	map.put("status", 1); // 아이디가 존재 할 때
        } else {
        	map.put("status", 0);
        }

        response.getWriter().print(objectMapper.writeValueAsString(map));
    }
    
    @ResponseBody
    @RequestMapping(value = "/member/insert", method = RequestMethod.POST)
    public ResponseStatus insertMember(HttpServletRequest request, ModelMap model, @ModelAttribute Member member, @ModelAttribute Address address) throws Exception {
    	    	
    	String msg = "";    
    	
    	ResponseStatus status = new ResponseStatus(0, msg);

    	if(address.getZipcode() != null && !address.getZipcode().isEmpty() && address.getAdd1() != null && !address.getAdd1().isEmpty()) {
    		seq++;
    		address.setSeq(seq);
    		// 여기서 주소 테이블 insert 했다 치고 ... 
    		member.setAddress_seq(address.getSeq());
    	}
    	
    	status = accountService.insertMember(member);
   	
    	
    	return status;
    }
}

package com.jbground.community.web.account;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbground.community.model.Address;
import com.jbground.community.model.Member;
import com.jbground.community.model.common.ResponseStatus;
import com.jbground.community.web.address.AddressService;

@RestController
public class RestAccountController {
	
	private final static Logger logger = LoggerFactory.getLogger(RestAccountController.class);
    
	@Resource(type = AccountService.class)
    private AccountService accountService;
	
	@Resource(type = AddressService.class)
    private AddressService addressService;

    @Resource(type = ObjectMapper.class)
    private ObjectMapper objectMapper;
	
    /**
     *  로그인 기능
     */
    @ResponseBody
    @RequestMapping(value = "/check/login", method = RequestMethod.POST)
    public ResponseStatus checkLogin(HttpServletRequest request, ModelMap model, @ModelAttribute Member member, HttpSession session) throws Exception {
    	
    	String msg = "";    

    	ResponseStatus status = new ResponseStatus(0, msg);

    	status = accountService.checkLogin(member);

    	if(status.getStatus() == 1) {
    		session.setAttribute("member", member);
    	}

        return status;
    }
    
    
    /**
     *  로그아웃 기능 
     */
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
    	
    	session.invalidate();

    }
    
    
    /**
     *  아이디 중복체크 기능
     */
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
    
    
    /**
     * 회원 가입 기능 
     */
    @ResponseBody
    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public ResponseStatus insertMember(HttpServletRequest request, @ModelAttribute Member member, @ModelAttribute Address address) throws Exception {
    	    	
    	String msg = "";    
    	
    	ResponseStatus status = new ResponseStatus(0, msg);


    	int seq =  addressService.insertAddress(address);

    	if(seq != 0) {
    		member.setAddress_seq(address.getSeq());
    	}

    	
    	status = accountService.insertMember(member);
    	
    	return status;
    }
}

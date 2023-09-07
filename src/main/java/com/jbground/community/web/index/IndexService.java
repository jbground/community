package com.jbground.community.web.index;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
	
	public Boolean checkLogin(HttpSession session) {
		
		if(session.getAttribute("member") != null) { // 로그인 상태
			return true;
		}
		
		return false; // 로그아웃 상태
		
	}
}

package com.jbground.community.web.account;

import com.jbground.community.model.Member;
import com.jbground.community.web.account.dao.MemberDao;
import com.jbground.community.web.account.dao.MemberRepository;

import org.checkerframework.checker.units.qual.m;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountService {

    private final static Logger logger = LoggerFactory.getLogger(AccountService.class);
    
    final int MIN = 8;
    final int MAX = 15;
    
    final String REGEX =  "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + MIN + "," + MAX + "})$";
    
    @Resource(type = MemberRepository.class)
    private MemberRepository memberRepository;

    @Resource(type = MemberDao.class)
    private MemberDao memberDao;

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public List<Member> getMembers2(){
        return memberDao.getMembers();
    }
    
    public int checkId(String id) {
		return memberDao.checkId(id);
    	
    }
    
    public String insertMember(Member member) {
    	

	    Pattern pattern_symbol = Pattern.compile(REGEX);
	    
	    Matcher matcher_symbol = pattern_symbol.matcher(member.getPassword());
    	
	    if(!(member.getId().isEmpty() || member.getId() == null)) {    	
	    	if(matcher_symbol.find()) {
	    		memberDao.insertMember(member);
	    		return "회원가입 성공";
	    	} else {
	    		return "비밀번호를 형식에 맞춰 작성해 주세요.";
	    	}
	    } 
	    
	    
		
	    return "다시 시도 해주세요.";
    
    }
    
}

package com.jbground.community.web.account;

import com.jbground.community.model.Member;
import com.jbground.community.model.common.ResponseStatus;
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
    
    final String PW_REGEX =  "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + MIN + "," + MAX + "})$";
    final String EMAIL_REGEX ="^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
    final String PHONE_REGEX ="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-(\\d{4})$"; 
    
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
    
    public ResponseStatus insertMember(Member member) {    
    	
    	String msg = "";
    	
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	// 비밀번호 유효성 체크
	    Pattern pattern_pw = Pattern.compile(PW_REGEX);	    
	    Matcher matcher_pw = pattern_pw.matcher(member.getPassword());
	    
	    // 이메일 유효성 체크
	    Pattern pattern_email = Pattern.compile(EMAIL_REGEX);
    	Matcher matcher_email = pattern_email.matcher(member.getEmail());
        
        // 핸드폰번호 유효성 체크
	    Pattern pattern_phone = Pattern.compile(PHONE_REGEX);
        Matcher matcher_phone = pattern_phone.matcher(member.getPhone());
	    
	    
	    int result = memberDao.checkId(member.getId());
	    
	   
	    if(!matcher_pw.find()) {
	    	return status = new ResponseStatus(0, "비밀번호를 형식에 맞춰 작성해 주세요.");
	    }


	    if(member.getEmail() != null && member.getEmail() != ""){
	    	if(!matcher_email.find()) {
	    		return status = new ResponseStatus(0, "이메일 형식에 맞춰 작성해 주세요.");
	    	}
	    }
	    
	    if(member.getPhone() != null && member.getPhone() != "") {
		    if(!matcher_phone.find()) {
		    	return status = new ResponseStatus(0, "전화번호 형식에 맞춰 작성해 주세요.");
		    }
	    }
	    
	    if(result == 1) {
	    	return status = new ResponseStatus(0, "이미 사용중인 아이디입니다, 중복체크를 진행해주세요.");
	    }
	    
	    if(!member.getPassword().equals(member.getCheckPassword())) {
	    	return status = new ResponseStatus(0, "비밀번호가 일치 하지 않습니다, 다시 확인 해주세요.");
	    }	    
	    
	    
	    memberDao.insertMember(member); 
	    
	    return status = new ResponseStatus(1, "회원가입 성공");
	    

    }
    
}

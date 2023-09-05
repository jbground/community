package com.jbground.community.web.account;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jbground.community.model.Member;
import com.jbground.community.model.common.ResponseStatus;
import com.jbground.community.web.account.dao.MemberDao;
import com.jbground.community.web.account.dao.MemberRepository;

@Service
public class AccountService {

    private final static Logger logger = LoggerFactory.getLogger(AccountService.class);
    
    private final int MIN = 8;
    private final int MAX = 15;
    
    private final String PW_REGEX =  "^((?=.*\\d)(?=.*[a-zA-Z])(?=.*[\\W]).{" + MIN + "," + MAX + "})$";
    private final String EMAIL_REGEX ="^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
    private final String PHONE_REGEX ="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-(\\d{4})$"; 
    
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
	    	return new ResponseStatus(0, "비밀번호를 형식에 맞춰 작성해 주세요.");
	    }


	    if(member.getEmail() != null && member.getEmail() != ""){
	    	if(!matcher_email.find()) {
	    		return new ResponseStatus(0, "이메일 형식에 맞춰 작성해 주세요.");
	    	}
	    }
	    
	    if(member.getPhone() != null && member.getPhone() != "") {
		    if(!matcher_phone.find()) {
		    	return new ResponseStatus(0, "전화번호 형식에 맞춰 작성해 주세요.");
		    }
	    }
	    
	    if(result == 1) {
	    	return new ResponseStatus(0, "이미 사용중인 아이디입니다, 중복체크를 진행해주세요.");
	    }
	    
	    if(!member.getPassword().equals(member.getCheckPassword())) {
	    	return new ResponseStatus(0, "비밀번호가 일치 하지 않습니다, 다시 확인 해주세요.");
	    }	    
	    
	    
	    memberDao.insertMember(member); 
	    
	    return new ResponseStatus(1, "회원가입 성공");
	    

    }
    
    
    public ResponseStatus checkLogin(Member member) {

    	if(member.getId() != null && !member.getId().isEmpty() && member.getPassword() != null && !member.getPassword().isEmpty()) {
    		// 아이디 체크
    		int checkId = memberDao.checkId(member.getId());

    		if(checkId == 0) { // 아이디가 없으면 ...
    			return new ResponseStatus(0, "등록되지 않은 아이디 입니다.");   			
    		}

    		// 아이디, 비밀번호 체크 
    		int result = memberDao.checkLogin(member);

    		if(result == 0) {
    			return new ResponseStatus(0, "비밀번호가 일치하지 않습니다.");
    		} 

    		return new ResponseStatus(1, "로그인 성공");

    	}


    	return new ResponseStatus(0, "로그인 실패");

    }
    
}

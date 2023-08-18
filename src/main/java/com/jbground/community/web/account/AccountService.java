package com.jbground.community.web.account;

import com.jbground.community.model.Member;
import com.jbground.community.web.account.dao.MemberDao;
import com.jbground.community.web.account.dao.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {

    private final static Logger logger = LoggerFactory.getLogger(AccountService.class);

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
    
    public void insertMember(Member member) {
    	memberDao.insertMember(member);
    }
}

package com.jbground.community.web.account.dao;

import com.jbground.community.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
    List<Member> getMembers();
    int checkId(String id);
    void insertMember(Member member);
    int checkLogin(Member member);

}

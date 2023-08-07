package com.jbground.community.web.account;

import com.jbground.community.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
    List<Member> getMembers();
}

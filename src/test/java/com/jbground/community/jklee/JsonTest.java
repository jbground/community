package com.jbground.community.jklee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbground.community.model.Member;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    void test1() throws JsonProcessingException {

        Member member = new Member();
        member.setId("asdsad");
        member.setNickname("fassd");
        member.setPhone("010-0000-0000");



        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(member);

        System.out.print("member toString() : ");
        System.out.println(member);
        System.out.println();
        System.out.print("json format : ");
        System.out.println(s);
    }
}

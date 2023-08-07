package com.jbground.community.web.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BoardDao {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSession;

    public void insert(String queryId, Object parameterObject) {
        sqlSession.insert(queryId, parameterObject);
    }
}

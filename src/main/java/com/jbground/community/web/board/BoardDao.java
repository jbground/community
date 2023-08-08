package com.jbground.community.web.board;

import com.jbground.community.config.AbstractMybatisMapper;
import com.jbground.community.model.Board;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BoardDao extends AbstractMybatisMapper {
    public List<Board> getAllBoardList() throws Exception {
        return selectList("board.selectAllBoardList");
    }
}

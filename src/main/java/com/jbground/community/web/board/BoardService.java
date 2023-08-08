package com.jbground.community.web.board;


import com.jbground.community.model.Board;
import com.jbground.community.web.board.dao.BoardDao;
import com.jbground.community.web.board.dao.BoardRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardService {

    @Resource(type = BoardDao.class)
    private BoardDao boardDao;

    @Resource(type = BoardRepository.class)
    private BoardRepository boardRepository;

    public List<Board> getAllBoardList() throws Exception {
        return boardDao.getAllBoardList();
    }

}

package com.jbground.community.web.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BoardService {

    @Resource(type = BoardDao.class)
    private BoardDao boardDao;

    @Resource(type = BoardRepository.class)
    private BoardRepository boardRepository;

}

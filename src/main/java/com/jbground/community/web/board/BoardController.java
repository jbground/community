package com.jbground.community.web.board;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbground.community.model.Board;

@Controller
public class BoardController {

    private final static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Resource(type = BoardService.class)
    private BoardService boardService;


    @RequestMapping(value = "/board/list")
    public String showBoard(HttpServletRequest request, ModelMap model) throws Exception{

        List<Board> allBoardList = boardService.getAllBoardList();

        for (Board b : allBoardList) {

            logger.info(b.toString());
        }

        return "thymeleaf/board/board_list";
    } 
    
}

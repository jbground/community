package com.jbground.community.web.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @RequestMapping(value = "/board")
    public String showBoard(){

        return "thymeleaf/board/board_list";
    }
}

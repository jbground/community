package com.jbground.community.web.board;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbground.community.model.Board;
import com.jbground.community.model.Member;
import com.jbground.community.web.index.IndexService;

@Controller
public class BoardController {

    private final static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Resource(type = BoardService.class)
    private BoardService boardService;
    
    @Resource(type = IndexService.class)
    private IndexService indexService;

    @RequestMapping(value = "/board/list")
    public String showBoard(HttpServletRequest request, ModelMap model,HttpSession session) throws Exception{
    	
        List<Board> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        
        boolean result = indexService.checkLogin(session);
        
        // 로그인, 로그아웃 버튼 
    	model.addAttribute("result", result);

        return "thymeleaf/board/board_list";
    } 
    
    @RequestMapping(value = "/board/view")
    public String showBoardView(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
    	
    	boolean result = indexService.checkLogin(session);
         
         // 로그인, 로그아웃 버튼 
     	model.addAttribute("result", result);
    	
    	model.addAttribute("member", session.getAttribute("member"));

        return "thymeleaf/board/board_view";
    } 
    
}

package com.jbground.community.web.board;

import com.jbground.community.model.Board;
import com.jbground.community.model.common.ResponseStatus;
import com.jbground.community.web.board.dao.BoardDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    
    @ResponseBody
    @RequestMapping(value= "/board/insert", method = RequestMethod.POST)
    public ResponseStatus insertBoard(HttpServletRequest request, ModelMap model, @ModelAttribute Board board) throws Exception{
		
    	String msg = "";    
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	return status;
    	
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/board/update", method = RequestMethod.POST)
    public ResponseStatus updateBoard(HttpServletRequest request, ModelMap model, @ModelAttribute Board board) throws Exception{
		
    	String msg = "";    
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	return status;	
    	
    }
    
    @ResponseBody
    @RequestMapping(value = "/board/delete", method = RequestMethod.POST)
    public ResponseStatus deleteBoard(HttpServletRequest request, ModelMap model, @ModelAttribute Board board) throws Exception{
		
    	String msg = "";    
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	return status;	
    	
    }
    
}

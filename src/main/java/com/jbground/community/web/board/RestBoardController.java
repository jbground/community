package com.jbground.community.web.board;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbground.community.model.Board;
import com.jbground.community.model.common.ResponseStatus;

@RestController
public class RestBoardController {

	private final static Logger Logger = LoggerFactory.getLogger(RestBoardController.class);
	
	@Resource(type = BoardService.class)
    private BoardService boardService;
	
	
	/**
	 * 게시판 글 생성
	 */  
    @ResponseBody
    @RequestMapping(value= "/board/{id}", method = RequestMethod.POST)
    public ResponseStatus insertBoard(HttpServletRequest request, @ModelAttribute Board board) throws Exception{
		
    	String msg = "";    
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	return status;
    	
    }
    
    /**
     * 게시판 글 수정
     */  
    @ResponseBody
    @RequestMapping(value = "/board/{id}", method = RequestMethod.PUT)
    public ResponseStatus updateBoard(HttpServletRequest request, @ModelAttribute Board board) throws Exception{
		
    	String msg = "";    
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	return status;	
    	
    }
    
    /**
     * 게시판 글 삭제
     */ 
    @ResponseBody
    @RequestMapping(value = "/board/{id}", method = RequestMethod.DELETE)
    public ResponseStatus deleteBoard(HttpServletRequest request, @ModelAttribute Board board) throws Exception{
		
    	String msg = "";    
    	ResponseStatus status = new ResponseStatus(0, msg);
    	
    	return status;	
    	
    }
}

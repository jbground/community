package com.jbground.community.web.board;

import com.jbground.community.model.Board;
import com.jbground.community.web.account.AccountController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {

    private final static Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Resource(type = BoardService.class)
    private BoardService boardService;

    @Resource(type = BoardDao.class)
    private BoardDao boardDao;

    @RequestMapping(value = "/board/list")
    public String showBoard(HttpServletRequest request, ModelMap model) throws Exception{

        List<Board> allBoardList = boardDao.getAllBoardList();

        for (Board b : allBoardList) {

            logger.info(b.toString());
        }

        return "thymeleaf/board/board_list";
    }
}

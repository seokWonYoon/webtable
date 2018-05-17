package board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/insertBoard")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
	
    public InsertBoardServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_name = request.getParameter("board_name");
		String mem_id = request.getParameter("mem_id");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_name(board_name);
		boardVO.setMem_id(mem_id);;
		
		int check = boardService.insertBoard(boardVO);
		if(check == 1) {
//			게시판 목록 보이기
			ServletContext application = getServletContext();
			List<BoardVO> boardList = boardService.getBoardList();
			application.setAttribute("boardList", boardList);
			
			response.sendRedirect(request.getContextPath()+"/manageBoard");
		} else {
			System.out.println("생성실패");
		}
		
		
	}

}

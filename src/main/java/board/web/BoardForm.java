package board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/boardForm")
public class BoardForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
       
    public BoardForm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		List<BoardVO> boardList = boardService.getBoardList();
		request.setAttribute("boardList", boardList);
		String mem_id = "" + session.getAttribute("mem_id");
		request.setAttribute("mem_id", mem_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardForm.jsp");
		rd.forward(request, response);
		
	}

}

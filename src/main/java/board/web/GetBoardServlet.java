package board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/getBoard")
public class GetBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();
       
    public GetBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getBoard 서블렛 시작");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardVO boardVO = boardService.getBoard(board_num);
		request.setAttribute("boardList", boardService.getBoardList());
		request.setAttribute("boardVO", boardVO);
		
		System.out.println("getboard 서블렛 포워딩 전"); 
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
		rd.forward(request, response);
		
	}

}





package board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/setBoard_yn")
public class setBoard_yn_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceInf boardService = new BoardService();

	public setBoard_yn_Servlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("setBoard_yn 시작");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
//		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_vital_yn = request.getParameter("board_vital_yn");
		
		BoardVO vo = new BoardVO();
		vo.setBoard_num(board_num);
		
		if(board_vital_yn.equals("Y") || board_vital_yn.equals("y")) {
			vo.setBoard_vital_yn("n");
		}else{
			vo.setBoard_vital_yn("y");
		}
		
		int check = boardService.setBoard_yn(vo);
		System.out.println(check);
		if(check > 0) {
			response.sendRedirect(request.getContextPath()+"/manageBoard");
		}else {
			response.sendRedirect(request.getContextPath()+"/getBoard");
		}
		
		
	}

}

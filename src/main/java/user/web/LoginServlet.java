package user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.glass.ui.Application;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		BoardServiceInf boardService = new BoardService();
		// as-is
		// LoginServlet 에서 userId,password 파라미터를응답으로 생성
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		UserVO user = new UserVO();
		user.setMem_id(mem_id);
		user.setMem_pass(mem_pass);
		
//		게시판 목록 보이기
		ServletContext application = getServletContext();
		List<BoardVO> boardList = boardService.getBoardList();
		application.setAttribute("boardList", boardList);

		// to-be
		// userId, password 파라미터에 해당하는 사용자가
		UserServiceInf us = new UserService();
		boolean loginResult = us.loginProcess(new UserVO("", mem_id, mem_pass));
		
		if(loginResult){
			
			//as-is : redirect / to-be : dispatch foward
			//response.sendRedirect("main.jsp");
			
			request.setAttribute("mem_id", mem_id);
			
			
			session.setAttribute("mem_id", mem_id);
			session.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("login/login.jsp");
		}
		
		System.out.println("loginResult : " + loginResult);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.ArticleVO;

@WebServlet("/articleList_to_write")
public class ArticleList_to_write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArticleList_to_write() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		String board_num = request.getParameter("board_num");
		
		System.out.println("articleList_to_write 서블렛 mem_id : " + mem_id + "\t\tboard_num : "+ board_num);
		ArticleVO articleVO = new ArticleVO();
		articleVO.setBoard_num(Integer.parseInt(board_num));
		articleVO.setMem_id(mem_id);
		
		request.setAttribute("articleVO", articleVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/articleWrite.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

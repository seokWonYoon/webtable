package comments.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.model.CommentsVO;
import comments.service.CommentsService;
import comments.service.CommentsServiceInf;

@WebServlet("/CommentsWriteServlet")
public class CommentsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentsServiceInf service;
	
    public CommentsWriteServlet() {
        super();
        service = new CommentsService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글쓰기 서블렛 시작");
		
		String board_num =request.getParameter("board_num");
		String article_num =request.getParameter("article_num");
		String mem_id =request.getParameter("mem_id");
		String comments_content =request.getParameter("comments_content");
		
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setArticle_num(Integer.parseInt(article_num));
		commentsVO.setComments_content(comments_content);
		commentsVO.setMem_id(mem_id);
		
		request.setAttribute("commentsVO", commentsVO);
		
		int insertCommnets = service.insertComments(commentsVO);
		if (insertCommnets == 1) {
			System.out.println("댓글저장 성공");
			RequestDispatcher rd = request.getRequestDispatcher("/board/articleDetail.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("댓글저장 실패");
		}
		
	}

}

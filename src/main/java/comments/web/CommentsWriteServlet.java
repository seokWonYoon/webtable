package comments.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.ArticleVO;
import board.model.BoardVO;
import board.service.ArticleService;
import board.service.ArticleServiceInf;
import comments.model.CommentsVO;
import comments.service.CommentsService;
import comments.service.CommentsServiceInf;

@WebServlet("/CommentsWriteServlet")
public class CommentsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentsServiceInf commentsService;
	private ArticleServiceInf articleService;
	
    public CommentsWriteServlet() {
        super();
        commentsService = new CommentsService();
        articleService = new ArticleService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println("댓글쓰기 서블렛 시작");
		
		String content = request.getParameter("replyContent");
		
		String board_num =request.getParameter("board_num");
		String article_num =request.getParameter("article_num");
		String mem_id =request.getParameter("mem_id");
		String comments_content =request.getParameter("comments_content");
		
		ArticleVO articleVO = articleService.getArticle(Integer.parseInt(article_num));
		
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setArticle_num(Integer.parseInt(article_num));
		commentsVO.setComments_content(comments_content);
		commentsVO.setMem_id(mem_id);
		int insertCommnets = commentsService.insertComments(commentsVO);
		
		List<CommentsVO> commentsList = commentsService.getCommentsList(Integer.parseInt(article_num));
		
		request.setAttribute("articleVO", articleVO);
		request.setAttribute("commentsVO", commentsVO);
		request.setAttribute("commentsList", commentsList);
		
		if (insertCommnets == 1) {
			System.out.println("댓글저장 성공");
			RequestDispatcher rd = request.getRequestDispatcher("/board/articleDetail.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("댓글저장 실패");
		}
		
	}

}

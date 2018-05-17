package comments.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.model.CommentsVO;
import comments.service.CommentsService;
import comments.service.CommentsServiceInf;
import board.model.ArticleVO;
import board.service.ArticleServiceInf;

@WebServlet("/CommentsDeleteServlet")
public class CommentsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentsServiceInf Service;
       
    public CommentsDeleteServlet() {
        super();
        Service = new CommentsService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String comments_numString =request.getParameter("comments_num");  
		
		int article_num = Integer.parseInt(comments_numString);
//		int board_num = Integer.parseInt(board_numString);
		
		System.out.println("mem_id : " + mem_id);
		System.out.println("article_num : " + article_num);
//		System.out.println("board_num : " + board_num);
		
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setMem_id(mem_id);
		commentsVO.setArticle_num(article_num);
//		articleVO.setBoard_num(board_num);
		
//		request.setAttribute("board_num", board_num);
		
		int deleteCnt = Service.deleteComments(commentsVO);
		// 3 페이지이동(list)
		
		//정상적으로 삭제될 경우
			if (deleteCnt==1) {
				response.sendRedirect(request.getContextPath()+"/getArticle?article_num="+article_num);
				System.out.println("삭제성공");
			} else { // 정상적으로 회원 삭제를 하지 못한 경우
				System.out.println("삭제실패");
			}
	}

}

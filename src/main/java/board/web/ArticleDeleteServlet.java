package board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.ArticleVO;
import board.service.ArticleService;
import board.service.ArticleServiceInf;

@WebServlet("/deleteArticle")
public class ArticleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleServiceInf articleService;
	
    public ArticleDeleteServlet() {
    	super();
    	articleService = new ArticleService();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String article_numString =request.getParameter("article_num");  
		String board_numString =request.getParameter("board_num");  
		int article_num = Integer.parseInt(article_numString);
		int board_num = Integer.parseInt(board_numString);
		
		System.out.println("mem_id : " + mem_id);
		System.out.println("article_num : " + article_num);
		System.out.println("board_num : " + board_num);
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setMem_id(mem_id);
		articleVO.setArticle_num(article_num);
//		articleVO.setBoard_num(board_num);
		
//		request.setAttribute("board_num", board_num);
		
		int deleteCnt = articleService.deleteArticle(articleVO);
		// 3 페이지이동(list)
		
		//정상적으로 삭제될 경우
			if (deleteCnt==1) {
				response.sendRedirect(request.getContextPath()+"/getArticlePageList?board_num="+board_num);
				System.out.println("삭제성공");
			} else { // 정상적으로 회원 삭제를 하지 못한 경우
				System.out.println("삭제실패");
			}
		
	}

}

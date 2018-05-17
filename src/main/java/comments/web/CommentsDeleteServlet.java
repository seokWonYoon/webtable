package comments.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comments.model.CommentsVO;
import comments.service.CommentsService;
import comments.service.CommentsServiceInf;
import attachFile.model.AttachFileVO;
import attachFile.service.AttachFileService;
import attachFile.service.AttachFileServiceInf;
import board.model.ArticleVO;
import board.service.ArticleService;
import board.service.ArticleServiceInf;

@WebServlet("/CommentsDeleteServlet")
public class CommentsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleServiceInf articleService = new ArticleService();
	CommentsServiceInf commentsService = new CommentsService();
	AttachFileServiceInf attachFileService = new AttachFileService();
	
    public CommentsDeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mem_id = request.getParameter("mem_id");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int article_num = Integer.parseInt(request.getParameter("article_num"));
		int comments_num = Integer.parseInt(request.getParameter("comments_num"));
		
		System.out.println("mem_id : " + mem_id);
		System.out.println("article_num : " + article_num);
		System.out.println("board_num : " + board_num);
		System.out.println("comments_num : " + comments_num);
		
			
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setMem_id(mem_id);
		commentsVO.setComments_num(comments_num);
		
		int deleteCnt = commentsService.deleteComments(commentsVO);
		
		ArticleVO articleVO = articleService.getArticle(article_num);
		List<AttachFileVO> attachFileList =  attachFileService.getAttach_fileList(article_num);
		List<CommentsVO> commentsList = commentsService.getCommentsList(article_num);
		
		request.setAttribute("articleVO", articleVO);
		request.setAttribute("attachFileList", attachFileList);
		request.setAttribute("commentsList", commentsList);
		
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

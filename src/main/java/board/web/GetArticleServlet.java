package board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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

@WebServlet("/getArticle")
@MultipartConfig(maxFileSize=3*1024*1024, maxRequestSize=3*1024*1024*5)
public class GetArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleServiceInf articleService = new ArticleService();
	CommentsServiceInf commentsService = new CommentsService();
	AttachFileServiceInf attachFileService = new AttachFileService();
       
    public GetArticleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		System.out.println("getArticle 서블렛 시작");
		int article_num = Integer.parseInt(request.getParameter("article_num"));
		
		ArticleVO articleVO = articleService.getArticle(article_num);
		List<AttachFileVO> attachFileList =  attachFileService.getAttach_fileList(article_num);
		List<CommentsVO> commentsList = commentsService.getCommentsList(article_num);
		
		request.setAttribute("articleVO", articleVO);
		request.setAttribute("attachFileList", attachFileList);
		request.setAttribute("commentsList", commentsList);
		
		System.out.println(attachFileList);
		System.out.println("getarticle 서블렛 포워딩 전");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/articleDetail.jsp");
		rd.forward(request, response);
		System.out.println("getarticle 서블렛 포워딩 후");
		
	}
}

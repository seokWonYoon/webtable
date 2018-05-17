package board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.ArticleVO;
import board.model.BoardVO;
import board.service.ArticleService;
import board.service.ArticleServiceInf;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/articleReply")
@MultipartConfig(maxFileSize=3*1024*1024, maxRequestSize=3*1024*1024*5)
public class ArticleReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleServiceInf articleService = new ArticleService();
	
    public ArticleReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("답글쓰기 써블렛 ");
		System.out.println("article_num" + request.getParameter("article_num"));
		System.out.println(request.getParameter("board_num"));
		System.out.println(request.getParameter("article_title"));
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("mem_id"));
		
		
		request.setCharacterEncoding("utf-8");
		String board_num = request.getParameter("board_num");
		String mem_id = (String) session.getAttribute("mem_id");
		String article_num = request.getParameter("article_num");
		String article_title = request.getParameter("article_title");
		String article_group_num = request.getParameter("article_group_num");
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setBoard_num(Integer.parseInt(board_num));
		articleVO.setMem_id(mem_id);
		articleVO.setArticle_num(Integer.parseInt(article_num));
		articleVO.setArticle_title(article_title);
		articleVO.setArticle_group_num(Integer.parseInt(article_group_num));
		
		request.setAttribute("articleVO", articleVO);
		System.out.println(articleVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/articleReply.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("답글쓰기 써블렛 ");
		
//		(article_num_seq.nextval, #{article_parent_num}, #{board_num},
//		#{article_group_num}, #{article_title}, #{article_content},
//		#{mem_id}, sysdate, 'n')
		
		request.setCharacterEncoding("utf-8");
		
		String article_num = request.getParameter("article_num");
		String article_parent_num = request.getParameter("article_num");
		String board_num = request.getParameter("board_num");
		String article_title = request.getParameter("article_title");
		String article_content = request.getParameter("smarteditor");
		String mem_id = request.getParameter("mem_id");
		String article_group_num = request.getParameter("article_group_num");
		System.out.println(article_group_num);
		
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setBoard_num(Integer.parseInt(board_num));
		articleVO.setArticle_parent_num(Integer.parseInt(article_num));
		articleVO.setArticle_group_num(Integer.parseInt(article_group_num));
		articleVO.setArticle_title(article_title);
		articleVO.setArticle_content(article_content);
		articleVO.setMem_id(mem_id);
		
		int check = articleService.replyArticle(articleVO);
		if(check == 1) {
			response.sendRedirect(request.getContextPath()+"/getArticlePageList?board_num="+board_num);
		} else {
			System.out.println("생성실패");
		}
	}
	
}

package board.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.ArticleService;
import board.service.ArticleServiceInf;


@WebServlet("/getArticlePageList")
public class GetArticlePageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleServiceInf boardService;
    
	public GetArticlePageListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("articleListServlet");
		System.out.println("board_num : " +request.getParameter("board_num"));
		boardService = new ArticleService();
				String pageString = request.getParameter("page");
				String pageSizeString = request.getParameter("pageSizeString");
				String board_numString = request.getParameter("board_num");
				
				int page = (pageString==null )? 1 : Integer.parseInt(pageString); 
				int pageSize = (pageSizeString==null) ? 10  : Integer.parseInt(pageSizeString); 
				int board_num = Integer.parseInt(board_numString); 
				
				System.out.println("page : " + page);
				System.out.println("pageSize : " + pageSize);
				System.out.println("board_num : " + board_num);
				Map<String, Object> resultMap = boardService.getArticlePageList(board_num, page, pageSize);
				
				Object forArticleList = resultMap.get("articleList");
				
				request.setAttribute("articleList", forArticleList);
				request.setAttribute("board_num", board_num);
				request.setAttribute("pageNav", resultMap.get("pageNav"));
				
				// forword
				RequestDispatcher rd = request.getRequestDispatcher("/board/articleList.jsp");
				rd.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

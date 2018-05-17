package board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import board.model.ArticleVO;
import board.service.ArticleService;
import board.service.ArticleServiceInf;
import util.FileUtil;

@WebServlet("/articleModify")
@MultipartConfig(maxFileSize=3*1024*1024, maxRequestSize=3*1024*1024*5)
public class ArticleModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleServiceInf articleService;
       
    public ArticleModifyServlet() {
        super();
        articleService= new ArticleService();
    }
    //사용자 수정 폼 요청시 사용
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int article_num = Integer.parseInt(request.getParameter("article_num"));
		
		//서비스 객체 통해서 getarticle
		ArticleVO articleVO=articleService.getArticle(article_num);
		System.out.println(articleVO);
		//request 객체에 article정보를 setAttribute
		request.setAttribute("articleVO", articleVO);
		
		//foward /article/articleModify.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/board/articleModify.jsp");
		rd.forward(request, response);
		
	}
	
	//사용자 정보 수정 시 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println((String) session.getAttribute("mem_id"));
		System.out.println("수정버튼 눌러서 서블렛 이동함1");

		int article_num = Integer.parseInt(request.getParameter("article_num"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String article_title = request.getParameter("article_title");
		String article_content = request.getParameter("smarteditor");
		String mem_id = (String) session.getAttribute("mem_id");
		System.out.println(mem_id);
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setArticle_num(article_num);
		articleVO.setBoard_num(board_num);
		articleVO.setArticle_title(article_title);;
		articleVO.setArticle_content(article_content);
		articleVO.setMem_id(mem_id);
		
//		//part에서 mem_profile 정보 (파일이름) 
//		Part mem_profilePart = request.getPart("mem_profile");
//		if (mem_profilePart.getSize()>0) {
//			String contentString = mem_profilePart.getHeader("Content-disposition");
//			String fileName = FileUtil.getFileName(contentString);
//			
//			//경로(uploadFolder)에 파일 저장
//			String uploadPath = getServletContext().getRealPath("/uploadFolder/");
//			mem_profilePath = "/uploadFolder/" + fileName;
//			String filePath = uploadPath + java.io.File.separator + fileName;
//			
//            mem_profilePart.write(filePath);
//            mem_profilePart.delete();
//        }
//		
//		ArticleVO originArticle = articleService.getArticle(mem_id);
//		if (originArticle.getMem_profile()==null){
//			originArticle.setMem_profile("");
//		}
//		if (mem_profilePath.equals("")) {
//			mem_profilePath = originArticle.getMem_profile();
//		}

		// vo-> modifyArticle
//		ArticleVO articleVO = new ArticleVO(mem_id, mem_name, mem_alias, mem_pass, mem_add1, mem_add2, mem_zip, mem_profilePath);
		
		int modifyArticleCnt = articleService.modifyArticle(articleVO);
		System.out.println(modifyArticleCnt);
		
		if (modifyArticleCnt==1) {
			response.sendRedirect(request.getContextPath()+"/getArticle?article_num="+article_num);
		} else { // 정상적으로 회원 입력을 하지 못한 경우

		}
	}
}

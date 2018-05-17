package board.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import util.FileUtil;
import attachFile.model.AttachFileVO;
import attachFile.service.AttachFileService;
import attachFile.service.AttachFileServiceInf;
import board.model.ArticleVO;
import board.model.BoardVO;
import board.service.ArticleService;
import board.service.ArticleServiceInf;
import board.service.BoardService;
import board.service.BoardServiceInf;

@WebServlet("/articleInsert")
@MultipartConfig(maxFileSize=3*1024*1024, maxRequestSize=3*1024*1024*5)
public class ArticleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleServiceInf articleService = new ArticleService();
	AttachFileServiceInf attachFileService = new AttachFileService();
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/7.JspSring/uploadStorage";
	
    public ArticleInsertServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("글쓰기 써블렛 ");
		System.out.println(request.getParameter("board_num"));
		System.out.println(request.getParameter("article_title"));
		System.out.println(request.getParameter("smarteditor"));
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("mem_id"));
		
		
		request.setCharacterEncoding("utf-8");
		String board_num = request.getParameter("board_num");
		String mem_id = (String) session.getAttribute("mem_id");
		String article_title = request.getParameter("article_title");
		String article_content = request.getParameter("smarteditor");
		
		
		ArticleVO articleVO = new ArticleVO();
		articleVO.setBoard_num(Integer.parseInt(board_num));
		articleVO.setMem_id(mem_id);
		articleVO.setArticle_title(article_title);
		articleVO.setArticle_content(article_content);
		int check = articleService.insertArticle(articleVO);
		
		int article_num = articleVO.getArticle_num();
		
		////////////////////////////////////////////////////////////////////////////////////// 글쓰기 내용
		System.out.println("파일첨부 시작");		
		Collection<Part> parts = request.getParts();
		AttachFileVO attachFileVO = new AttachFileVO();
		
		for (Part part : parts) {
			 System.out.println("FileUtil.getFileName(part.getHeader('Content-disposition')) : "+FileUtil.getFileName(part.getHeader("Content-disposition"))); 
			if (part.getName().equals("attach_file_name") && part.getSize()>0) {
//			if (part.getName().equals("attach_file_name") && (FileUtil.getFileName(part.getHeader("Content-disposition"))).trim()!=null) {
				String contentString = part.getHeader("Content-disposition");
				String fileName = FileUtil.getFileName(contentString);
				
				String filetype = fileName.substring(fileName.lastIndexOf("."));
				System.out.println(fileName);
				String uuid = File.separator+UUID.randomUUID().toString()+filetype;
				String real_uuid = uuid.substring(1);
				String filePaht = UPLOAD_PATH+uuid;
				part.write(filePaht);
				
				System.out.println(uuid);
				part.delete();
				
				attachFileVO.setArticle_num(article_num);
				attachFileVO.setAttach_file_name(real_uuid);
				attachFileVO.setAttach_file_real_name(fileName);
				attachFileService.insertAttach_file(attachFileVO);
				
			}
		}
		System.out.println("파일첨부 끝");		
		
		///////////////////////////////////////////////////////////////////////////////////////글쓰기 저장

		if(check == 1) {
			response.sendRedirect(request.getContextPath()+"/getArticlePageList?board_num="+board_num);
		} else {
			System.out.println("생성실패");
		}
		
	}

}

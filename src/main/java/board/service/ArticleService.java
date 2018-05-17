package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.ArticleDao;
import board.dao.ArticleDaoInf;
import board.model.ArticleVO;

public class ArticleService implements ArticleServiceInf {
	private ArticleDaoInf articleDao;
	
	public ArticleService(){
		articleDao = ArticleDao.getInstance();
	}
	
	@Override
	public Map<String, Object> getArticlePageList(int board_num, int page, int pageSize) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<ArticleVO> articleList = (List<ArticleVO>) articleDao.getArticlePageList(board_num, page, pageSize);
		int articleTotalCnt = articleDao.getArticleTotalCnt(board_num);
		
		String pageNav = makePageNav(board_num, page, articleTotalCnt);
		resultMap.put("articleList", articleList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}

	@Override
	public ArticleVO getArticle(int article_num) {
		ArticleVO articleVO = articleDao.getArticle(article_num);
		return articleVO;
	}

	@Override
	public int insertArticle(ArticleVO articleVO) {
		int insertCnt = articleDao.insertArticle(articleVO);
		return insertCnt;
	}
	@Override
	public int replyArticle(ArticleVO articleVO) {
		int insertCnt = articleDao.replyArticle(articleVO);
		return insertCnt;
	}

	@Override
	public int deleteArticle(ArticleVO articleVO) {
		int deleteCnt = articleDao.deleteArticle(articleVO);
		return deleteCnt;
	}

	@Override
	public int modifyArticle(ArticleVO articleVO) {
		int modifyUserCnt = articleDao.modifyArticle(articleVO);
		return modifyUserCnt;
	}
	
	
	private String makePageNav(int board_num,int page, int articleTotalCnt) {
		//articleTotalCnt = 26
		//pageSize 10
		//totalPage 3
		int pageTotalCnt = (int) Math.ceil((double)articleTotalCnt / 10);
		int prePage = (page-1>0)?page-1:1;
		int nextPage = (page+1<pageTotalCnt)?page+1:pageTotalCnt;
		StringBuffer pageNav= new StringBuffer();
		pageNav.append("<nav>");
			pageNav.append("<ul class=\"pagination\">");
				pageNav.append("<li id=\"firstPage\">");
					pageNav.append("<a href=\"getArticlePageList?page=1&pageSize=10&board_num="+board_num+"\" aria-label=\"FirstPage\">");
						pageNav.append("<span aria-hidden=\"true\">&laquo;</span>");
					pageNav.append("</a>");
				pageNav.append("</li>");
				
				pageNav.append("<li id=\"previous\">");
					pageNav.append("<a href=\"getArticlePageList?page="+prePage+"&pageSize=10&board_num="+board_num+"\" aria-label=\"Previous\">");
						pageNav.append("<span aria-hidden=\"true\">&lsaquo;</span>");
					pageNav.append("</a>");
				pageNav.append("</li>");
				
				//pageTotalCnt
				//pageTotalCnt 만큼 루프를 돌리고 싶을때
				for (int i = 1; i <= pageTotalCnt; i++) {
					if ( i == page){
						pageNav.append("<li class=\"active\"><a href=\"getArticlePageList?page="+i+"&pageSize=10&board_num="+board_num+"\">"+ i +"</a></li>");
					} else {
						pageNav.append("<li><a href=\"getArticlePageList?page="+ i +"&pageSize=10&board_num="+board_num+"\">"+ i +"</a></li>");
					}
					
				}

				pageNav.append("<li id=\"next\">");
					pageNav.append("<a href=\"getArticlePageList?page="+nextPage+"&pageSize=10&board_num="+board_num+"\" aria-label=\"Next\">");
						pageNav.append("<span aria-hidden=\"true\">&rsaquo;</span>");
					pageNav.append("</a>");
				pageNav.append("</li>");
				
				pageNav.append("<li id=\"last\">");
					pageNav.append("<a href=\"getArticlePageList?page="+ pageTotalCnt +"&pageSize=10&board_num="+board_num+"\" aria-label=\"Last\">");
						pageNav.append("<span aria-hidden=\"true\">&raquo;</span>");
				pageNav.append("</a>");
				pageNav.append("</li>");
			pageNav.append("</ul>");
		pageNav.append("</nav>");
		
		return pageNav.toString();
		
	}
	
	

}

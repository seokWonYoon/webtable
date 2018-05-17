package board.service;

import java.util.Map;

import board.model.ArticleVO;

public interface ArticleServiceInf {
	/**
	 * 
	* Method : getArticlePageList
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param board_num
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 페이징 된 리스트를 반환한다
	 */
	public Map<String, Object> getArticlePageList(int board_num, int page, int pageSize) ;
	
	
	/**
	 * 
	* Method : getArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param article_num
	* @return
	* Method 설명 : 글상세보기
	 */
	public ArticleVO getArticle(int article_num);
	
	/**
	 * 
	* Method : insertArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param articleVO
	* @return
	* Method 설명 : 글쓰기 
	 */
	public int insertArticle(ArticleVO articleVO);
	
	/**
	 * 
	* Method : deleteArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param article_num
	* @return
	* Method 설명 : 삭제상태로 업데이트
	 */
	public int deleteArticle(ArticleVO articleVO);
	
	/**
	 * 
	* Method : modifyArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param articleVO
	* @return
	* Method 설명 : 글내용을 수정한다
	 */
	public int modifyArticle(ArticleVO articleVO);


	int replyArticle(ArticleVO articleVO);


}

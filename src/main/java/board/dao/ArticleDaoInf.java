/**
 * 
 */
package board.dao;

import java.util.List;

import board.model.ArticleVO;

/**
 * ArticleDaoInf.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 14.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 14. "Y.S.W" 최초 생성
 *
 * </pre>
 */
public interface ArticleDaoInf {
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
	public List<ArticleVO> getArticlePageList(int board_num, int page, int pageSize) ;
	
	/**
	 * 
	* Method : getArticleTotalCnt
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param board_num
	* @return
	* Method 설명 : 전체 글수 반환
	 */
	public int getArticleTotalCnt(int board_num);
	
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

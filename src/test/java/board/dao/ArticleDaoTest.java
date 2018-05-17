package board.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.dao.ArticleDao;
import board.dao.ArticleDaoInf;
import board.model.ArticleVO;
import user.model.UserVO;

public class ArticleDaoTest {
	ArticleDaoInf arcticleDao;
	ArticleVO articleVO;
	
	@Before
	public void setUp(){
		arcticleDao = ArticleDao.getInstance();
		articleVO = new ArticleVO();
	}
	/**
	 * 
	* Method : getArticlePageListTest
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 페이지 리스트 테스트
	 */
	@Test
	public void getArticlePageListTest(){
		/***Given***/
		int page = 1;
		int pageSize = 10;
		int board_num =1;
		
		/***When***/
		List<ArticleVO> articleList = arcticleDao.getArticlePageList(board_num, page, pageSize);
		
		/***Then***/
		// mybatis 실행을 통해 리턴결과가 !null
		assertNotNull(articleList);
		
		// 1페이지를 조회하면 10건
		assertEquals(6, articleList.size());
	}
	
	
	/**
	 * 
	* Method : getArticleTotalCnt
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 페이지 총 글 수 테스트
	 */
	@Test
	public void getArticleTotalCnt(){
		/***Given***/
		int board_num = 1;
		/***When***/
		int articleTotalCnt = arcticleDao.getArticleTotalCnt(board_num);
		
		/***Then***/
		assertEquals(6, articleTotalCnt);
	}
	
	
	/**
	 * 
	* Method : getArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 게시판 상세보기 테스트
	 */
	@Test
	public void getArticle(){
		/***Given***/
		int article_num = 1;
		/***When***/
		ArticleVO articleChkVO = arcticleDao.getArticle(article_num);
		
		/***Then***/
		assertEquals(article_num, articleChkVO.getArticle_num());
		assertEquals("test", articleChkVO.getMem_id());
	}
	

	/**
	 * 
	* Method : insertArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 게시판 쓰기 테스트
	 */
	@Test
	public void insertArticle(){
		/***Given***/
//		new ArticleVO(article_num, article_parent_num, board_num, article_group_num, article_title, article_content, mem_id, article_datetime, article_delete_yn);
		ArticleVO articleChkVO = new ArticleVO(1, 0, 1, 1, "test_title", "test_content", "test", new Date(), "n");

		/***When***/
		int insertCnt = arcticleDao.insertArticle(articleChkVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	

	/**
	 * 
	* Method : deleteArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 게시판 삭제 테스트
	 */
	@Test
	public void deleteArticle(){
		/***Given***/
		int article_num = 1;

		/***When***/
		int deleteUserCnt = arcticleDao.deleteArticle(articleVO);
		
		/***Then***/
//		assertNotEquals(0, deleteUserCnt);
		assertNotSame(0, deleteUserCnt);
	}
	

	/**
	 * 
	* Method : modifyArticle
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 게시판 수정 테스트
	 */
	@Test
	public void modifyArticle(){
		/***Given***/
		articleVO = new ArticleVO(1, 0, 1, 1, "test_title", "test_content", "test", new Date(), "n");
		
		/***When***/
		int modifyUserCnt =  arcticleDao.modifyArticle(articleVO);
		
		/***Then***/
//		assertNotEquals(1, modifyUserCnt);
		assertEquals(1, modifyUserCnt);
	}
}

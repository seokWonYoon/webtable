package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;





import board.model.ArticleVO;

import com.ibatis.common.resources.Resources;

public class ArticleDao implements ArticleDaoInf {
	private static ArticleDaoInf dao = new ArticleDao();
	private SqlSessionFactory sqlSessionFactory;

	public static ArticleDaoInf getInstance() {
		return dao;
	}
	
	public ArticleDao() {
		String resource = "db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ArticleDao 싱글톤 적용 완료");
	}

	@Override
	public List<ArticleVO> getArticlePageList(int board_num, int page, int pageSize) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("board_num", board_num);
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ArticleVO> articlePageList = sqlSession.selectList("article.getArticlePageList", paramMap);
		sqlSession.close();
		return articlePageList;
	}

	@Override
	public int getArticleTotalCnt(int board_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int articleTotalCnt = sqlSession.selectOne("article.getArticleTotalCnt", board_num);
		sqlSession.close();
		return articleTotalCnt;
	}

	@Override
	public ArticleVO getArticle(int article_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArticleVO articleVO = sqlSession.selectOne("article.getArticle", article_num);
		sqlSession.close();
		return articleVO;
	}

	@Override
	public int insertArticle(ArticleVO articleVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertArticleCnt = sqlSession.insert("article.insertArticle", articleVO);
		sqlSession.commit();
		sqlSession.close();
		return insertArticleCnt;
	}

	@Override
	public int replyArticle(ArticleVO articleVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertArticleCnt = sqlSession.insert("article.replyArticle", articleVO);
		sqlSession.commit();
		sqlSession.close();
		return insertArticleCnt;
	}

	@Override
	public int deleteArticle(ArticleVO articleVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteArticleCnt = sqlSession.update("article.deleteArticle", articleVO);
		sqlSession.commit();
		sqlSession.close();
		return deleteArticleCnt;
	}

	@Override
	public int modifyArticle(ArticleVO articleVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int modifyArticleCnt = sqlSession.update("article.modifyArticle", articleVO);
		sqlSession.commit();
		sqlSession.close();
		return modifyArticleCnt;
	}
	
	
	
}

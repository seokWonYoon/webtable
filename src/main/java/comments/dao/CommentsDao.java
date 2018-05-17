package comments.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import comments.model.CommentsVO;

public class CommentsDao implements CommentsDaoInf {
	private static CommentsDaoInf dao = new CommentsDao();
	private SqlSessionFactory sqlSessionFactory;

	public static CommentsDaoInf getInstance() {
		return dao;
	}
	
	public CommentsDao() {
		String resource = "db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("CommentDao 싱글톤 적용 완료");
	}
	
	@Override
	public List<CommentsVO> getCommentsList(int article_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<CommentsVO> commentsList = sqlSession.selectList("comments.getBoardList", article_num);
		sqlSession.close();
		return commentsList;
	}

	@Override
	public int modifyComments(CommentsVO commentsVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int modifyCommentsCnt = sqlSession.update("comments.modifyComments", commentsVO);
		sqlSession.commit();
		sqlSession.close();
		return modifyCommentsCnt;
	}

	@Override
	public int deleteComments(CommentsVO commentsVO) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("comments.deleteComments", commentsVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	@Override
	public int insertComments(CommentsVO commentsVO) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("comments.insertComments", commentsVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

}

package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVO;

public class BoardDao implements BoardDaoInf {
	
	private static BoardDaoInf dao = new BoardDao();
	private SqlSessionFactory sqlSessionFactory;
	
	public static BoardDaoInf getInstance() {
		return dao;
	}
	
	private BoardDao(){
		String resource = "db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("BoardDao 싱글톤 적용 완료");
	}

	
	@Override
	public List<BoardVO> getBoardList() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardVO> boardList = sqlSession.selectList("board.getBoardList");
		sqlSession.close();
		
		return boardList;
	}

	
	@Override
	public BoardVO getBoard(int board_num) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardVO boardVO = sqlSession.selectOne("board.getBoard", board_num);
		sqlSession.close();
		
		return boardVO;
	}

	
	@Override
	public int setBoard_yn(BoardVO boardVO) {
		
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("board.setBoard_yn", boardVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	
	
	@Override
	public int insertBoard(BoardVO boardVO) {
		
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("board.insertBoard", boardVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

	

}


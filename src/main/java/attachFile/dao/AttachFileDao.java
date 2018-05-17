package attachFile.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVO;
import attachFile.model.AttachFileVO;

public class AttachFileDao implements AttachFileDaoInf {
	
	private static AttachFileDaoInf dao = new AttachFileDao();
	private SqlSessionFactory sqlSessionFactory;
	
	public static AttachFileDaoInf getInstance() {
		return dao;
	}
	private AttachFileDao(){
		String resource = "db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("AttachFileDao 싱글톤 적용 완료");
	}

	@Override
	public List<AttachFileVO> getAttach_fileList(int article_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<AttachFileVO> attachFileList = sqlSession.selectList("attach_file.getAttach_fileList", article_num);
		sqlSession.close();
		
		return attachFileList;
	}

	@Override
	public AttachFileVO getAttach_file(int attach_file_num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AttachFileVO attachFileVO = sqlSession.selectOne("attach_file.getAttach_file", attach_file_num);
		sqlSession.close();
		return attachFileVO;
	}

	@Override
	public int insertAttach_file(AttachFileVO attachFileVO) {
		int result = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("attach_file.insertAttach_file", attachFileVO);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}

}

package user.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.model.UserVO;

/**
 * 
 * UserDao.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 14.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 14. "Y.S.W" 최초 생성
 *
 * </pre>
 */
public class UserDao implements UserDaoInf {
	private SqlSessionFactory sqlSessionFactory;

	public UserDao() {
		String resource = "db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserVO getUser(String mem_id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserVO user = sqlSession.selectOne("user.getUser", mem_id);
		sqlSession.close();
		return user;
	}


}

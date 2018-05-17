package user.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import user.model.UserVO;

public class UserDaoTest {
	UserDaoInf userDao;
	UserVO userVO;

	@Before
	public void getUserDaoTestSetUp() {
		userDao = new UserDao();
		userVO = new UserVO("test", "test", "1234");
	}
	
	/**
	 * 
	* Method : loginProcessTest
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 로그인 프로세스 테스트
	 */
	@Test
	public void loginProcessTest(){
		/***Given***/
		String mem_id = "test";
		/***When***/
		UserVO vo = userDao.getUser(mem_id);
		
		/***Then***/
		System.out.println("vo.getMem_id(): "+ vo.getMem_id() +"\nvo.getMem_name() : "+vo.getMem_name());
		assertEquals("test", vo.getMem_id());
	}
	
	
	
}

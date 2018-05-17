package user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import user.dao.UserDao;
import user.dao.UserDaoInf;
import user.model.UserVO;

public class UserServiceTest {
	UserDaoInf userDao;
	UserServiceInf userService;
	UserVO userVO;

	@Before
	public void getUserPageListTestSetUp() {
		userDao = new UserDao();
		userService = new UserService();
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
		UserVO vo = userService.getUser(mem_id);
		
		/***Then***/
		System.out.println("vo.getMem_id(): "+ vo.getMem_id() +"\nvo.getMem_name() : "+vo.getMem_name());
		assertEquals("test", vo.getMem_id());
	}
	
}

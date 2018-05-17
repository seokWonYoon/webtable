package user.service;


import user.dao.UserDao;
import user.dao.UserDaoInf;
import user.model.UserVO;

public class UserService implements UserServiceInf {
	private UserDaoInf userDao;
	
//	private List<UserVO> userList; //저장소
	
	public UserService(){
		userDao = new UserDao();
//		userList = new ArrayList<UserVO>();
//		userList.add(new UserVO("test", "test", "1234"));
	}
	
	
	/**
	 * 
	* Method : loginProcess
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 : 로그인 프로세스
	 */
	@Override
	public boolean loginProcess(UserVO userVO) {
		boolean cnt = false; 
		UserVO loginVO = userDao.getUser(userVO.getMem_id());
		if (loginVO.getMem_id().equals(userVO.getMem_id())  &&  loginVO.getMem_pass().equals(userVO.getMem_pass())) {cnt = true;}
		else {cnt = false;}
		return cnt;
	}

	@Override
	public UserVO getUser(String mem_id) {
		UserVO userVO = userDao.getUser(mem_id);
		return userVO;
	}

}

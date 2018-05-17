package user.service;

import user.model.UserVO;

/**
 * 
* UserServiceInf.java
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
public interface UserServiceInf {
	public boolean loginProcess(UserVO userVO);
	public UserVO getUser(String mem_id);
}

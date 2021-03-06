package user.dao;

import java.util.List;

import user.model.UserVO;

/**
 * 
* UserDaoInf.java
*
* @author Y.S.W
* @since 2018. 5. 3.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 5. 3. Y.S.W 최초 생성
*
* </pre>
 */
public interface UserDaoInf {

	public UserVO getUser(String mem_id);
}

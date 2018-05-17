package attachFile.dao;

import java.util.List;

import attachFile.model.AttachFileVO;
import board.model.BoardVO;

/**
 * 
* AttachFileInf.java
*
* @author "Y.S.W"
* @since 2018. 5. 16.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 5. 16. "Y.S.W" 최초 생성
*
* </pre>
 */
public interface AttachFileDaoInf {
	public List<AttachFileVO> getAttach_fileList(int article_num);
	public AttachFileVO getAttach_file(int attach_file_num);
	public int insertAttach_file(AttachFileVO attachFileVO);
}

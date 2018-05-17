package attachFile.service;

import java.util.List;

import attachFile.model.AttachFileVO;

public interface AttachFileServiceInf {
	public List<AttachFileVO> getAttach_fileList(int article_num);
	public AttachFileVO getAttach_file(int attach_file_num);
	public int insertAttach_file(AttachFileVO attachFileVO);
}

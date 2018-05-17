package attachFile.service;

import java.util.List;

import attachFile.dao.AttachFileDao;
import attachFile.dao.AttachFileDaoInf;
import attachFile.model.AttachFileVO;

public class AttachFileService implements AttachFileServiceInf {
	private AttachFileDaoInf dao;
	
	public AttachFileService(){
		dao = AttachFileDao.getInstance();
	}

	@Override
	public List<AttachFileVO> getAttach_fileList(int article_num) {
		return dao.getAttach_fileList(article_num);
	}

	@Override
	public AttachFileVO getAttach_file(int attach_file_num) {
		return dao.getAttach_file(attach_file_num);
	}

	@Override
	public int insertAttach_file(AttachFileVO attachFileVO) {
		return dao.insertAttach_file(attachFileVO);
	}

}

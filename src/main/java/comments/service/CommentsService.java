package comments.service;

import java.util.List;

import comments.dao.CommentsDao;
import comments.dao.CommentsDaoInf;
import comments.model.CommentsVO;

public class CommentsService implements CommentsServiceInf {
	
	private CommentsDaoInf dao;
	
	public CommentsService(){
		dao = CommentsDao.getInstance();
	}
	
	@Override
	public List<CommentsVO> getCommentsList(int article_num) {
		return dao.getCommentsList(article_num);
	}

	@Override
	public int modifyComments(CommentsVO commentsVO) {
		return dao.modifyComments(commentsVO);
	}

	@Override
	public int deleteComments(CommentsVO commentsVO) {
		return dao.deleteComments(commentsVO);
	}

	@Override
	public int insertComments(CommentsVO commentsVO) {
		return dao.insertComments(commentsVO);
	}

}

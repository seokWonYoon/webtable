package comments.service;

import java.util.List;

import comments.model.CommentsVO;

public interface CommentsServiceInf {
	public List<CommentsVO> getCommentsList(int article_num);
	public int modifyComments(CommentsVO commentsVO);
	public int deleteComments(CommentsVO commentsVO);
	public int insertComments(CommentsVO commentsVO);
}

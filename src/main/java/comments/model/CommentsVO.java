package comments.model;

import java.util.Date;

public class CommentsVO {
	private int comments_num;
	private int article_num;
	private Date comments_datetime;
	private String mem_id;
	private String comments_content;
	private String comments_delete_yn;
	public int getComments_num() {
		return comments_num;
	}
	public void setComments_num(int comments_num) {
		this.comments_num = comments_num;
	}
	public int getArticle_num() {
		return article_num;
	}
	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}
	public Date getComments_datetime() {
		return comments_datetime;
	}
	public void setComments_datetime(Date comments_datetime) {
		this.comments_datetime = comments_datetime;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public String getComments_delete_yn() {
		return comments_delete_yn;
	}
	public void setComments_delete_yn(String comments_delete_yn) {
		this.comments_delete_yn = comments_delete_yn;
	}
	@Override
	public String toString() {
		return "CommentsVO [comments_num=" + comments_num + ", article_num="
				+ article_num + ", comments_datetime=" + comments_datetime
				+ ", mem_id=" + mem_id + ", comments_content="
				+ comments_content + ", comments_delete_yn="
				+ comments_delete_yn + "]";
	}
	
	
}

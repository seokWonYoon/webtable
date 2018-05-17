package board.model;

import java.util.Date;

public class ArticleVO {

	private int article_num;
	private int article_parent_num;
	private int board_num;
	private int article_group_num;
	private String article_title;
	private String article_content;
	private String mem_id;
	private Date article_datetime;
	private String article_delete_yn;
	private String level;
	
	public ArticleVO() {
		// TODO Auto-generated constructor stub
	}

	public ArticleVO(int article_num, int article_parent_num, int board_num,
			int article_group_num, String article_title,
			String article_content, String mem_id, Date article_datetime,
			String article_delete_yn) {
		this.article_num = article_num;
		this.article_parent_num = article_parent_num;
		this.board_num = board_num;
		this.article_group_num = article_group_num;
		this.article_title = article_title;
		this.article_content = article_content;
		this.mem_id = mem_id;
		this.article_datetime = article_datetime;
		this.article_delete_yn = article_delete_yn;
	}

	public int getArticle_num() {
		return article_num;
	}

	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}

	public int getArticle_parent_num() {
		return article_parent_num;
	}

	public void setArticle_parent_num(int article_parent_num) {
		this.article_parent_num = article_parent_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public int getArticle_group_num() {
		return article_group_num;
	}

	public void setArticle_group_num(int article_group_num) {
		this.article_group_num = article_group_num;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Date getArticle_datetime() {
		return article_datetime;
	}

	public void setArticle_datetime(Date article_datetime) {
		this.article_datetime = article_datetime;
	}

	public String getArticle_delete_yn() {
		return article_delete_yn;
	}

	public void setArticle_delete_yn(String article_delete_yn) {
		this.article_delete_yn = article_delete_yn;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "ArticleVO [article_num=" + article_num
				+ ", article_parent_num=" + article_parent_num + ", board_num="
				+ board_num + ", article_group_num=" + article_group_num
				+ ", article_title=" + article_title + ", article_content="
				+ article_content + ", mem_id=" + mem_id
				+ ", article_datetime=" + article_datetime
				+ ", article_delete_yn=" + article_delete_yn + "]";
	}
	
		
}

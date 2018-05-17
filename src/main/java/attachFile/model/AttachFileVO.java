package attachFile.model;

import java.util.Date;

public class AttachFileVO {
	private int attach_file_num;
	private String attach_file_name;
	private String attach_file_real_name;
	private int article_num;
	private Date attach_file_datetime;
	
	public AttachFileVO() {
	}
	public AttachFileVO(int attach_file_num, String attach_file_name,
			String attach_file_real_name, int article_num,
			Date attach_file_datetime) {
		this.attach_file_num = attach_file_num;
		this.attach_file_name = attach_file_name;
		this.attach_file_real_name = attach_file_real_name;
		this.article_num = article_num;
		this.attach_file_datetime = attach_file_datetime;
	}
	public int getAttach_file_num() {
		return attach_file_num;
	}
	public void setAttach_file_num(int attach_file_num) {
		this.attach_file_num = attach_file_num;
	}
	public String getAttach_file_name() {
		return attach_file_name;
	}
	public void setAttach_file_name(String attach_file_name) {
		this.attach_file_name = attach_file_name;
	}
	public String getAttach_file_real_name() {
		return attach_file_real_name;
	}
	public void setAttach_file_real_name(String attach_file_real_name) {
		this.attach_file_real_name = attach_file_real_name;
	}
	public int getArticle_num() {
		return article_num;
	}
	public void setArticle_num(int article_num) {
		this.article_num = article_num;
	}
	public Date getAttach_file_datetime() {
		return attach_file_datetime;
	}
	public void setAttach_file_datetime(Date attach_file_datetime) {
		this.attach_file_datetime = attach_file_datetime;
	}
	@Override
	public String toString() {
		return "AttachFileVO [attach_file_num=" + attach_file_num
				+ ", attach_file_name=" + attach_file_name
				+ ", attach_file_real_name=" + attach_file_real_name
				+ ", article_num=" + article_num + ", attach_file_datetime="
				+ attach_file_datetime + "]\n" ;
	}
	
	
}

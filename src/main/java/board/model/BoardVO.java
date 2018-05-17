package board.model;

import java.util.Date;

public class BoardVO {
	private int board_num;
	private String board_name;
	private Date board_datetime;
	private String board_vital_yn;
	private String mem_id;
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public Date getBoard_datetime() {
		return board_datetime;
	}
	public void setBoard_datetime(Date board_datetime) {
		this.board_datetime = board_datetime;
	}
	public String getBoard_vital_yn() {
		return board_vital_yn;
	}
	public void setBoard_vital_yn(String board_vital_yn) {
		this.board_vital_yn = board_vital_yn;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}

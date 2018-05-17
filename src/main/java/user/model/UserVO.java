package user.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserVO implements HttpSessionBindingListener {
	private String mem_id,mem_pass,mem_name,mem_add1,mem_add2,mem_zip, mem_alias, mem_profile;
	public String getMem_profile() {
		return mem_profile;
	}
	
	

	public UserVO(String mem_id, String mem_name, String mem_alias, String mem_pass,
			String mem_add1, String mem_add2, String mem_zip, String mem_profile) {
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_alias = mem_alias;
		this.mem_pass = mem_pass;
		this.mem_add1 = mem_add1;
		this.mem_add2 = mem_add2;
		this.mem_zip = mem_zip;
		this.mem_profile=mem_profile;
	}



	public String getMem_alias() {
		return mem_alias;
	}



	public void setMem_alias(String mem_alias) {
		this.mem_alias = mem_alias;
	}



	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}

	private Date mem_bir;
	
	
	public UserVO() {
	}

	public UserVO(String mem_name, String mem_id, String mem_pass) {
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
	}


	/**
	 * 
	* Method : valueBound
	* 최초작성일 : 2018. 5. 3.
	* 작성자 : Y.S.W
	* 변경이력 :
	* @param event
	* Method 설명 :
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("valueBound :" + event.getName());
	}

	/**
	 * 
	* Method : valueUnbound
	* 최초작성일 : 2018. 5. 3.
	* 작성자 : Y.S.W
	* 변경이력 :
	* @param event
	* Method 설명 :
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("valueUnbound :" + event.getName());
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_add1() {
		return mem_add1;
	}

	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}

	public String getMem_add2() {
		return mem_add2;
	}

	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}

	public String getMem_zip() {
		return mem_zip;
	}

	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}

	public Date getMem_bir() {
		return mem_bir;
	}

	public void setMem_bir(Date mem_bir) {
		this.mem_bir = mem_bir;
	}

	@Override
	public String toString() {
		return "UserVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass
				+ ", mem_name=" + mem_name + ", mem_add1=" + mem_add1
				+ ", mem_add2=" + mem_add2 + ", mem_zip=" + mem_zip
				+ ", mem_alias=" + mem_alias + ", mem_profile=" + mem_profile
				+ ", mem_bir=" + mem_bir + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		result = prime * result
				+ ((mem_name == null) ? 0 : mem_name.hashCode());
		result = prime * result
				+ ((mem_pass == null) ? 0 : mem_pass.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		if (mem_name == null) {
			if (other.mem_name != null)
				return false;
		} else if (!mem_name.equals(other.mem_name))
			return false;
		if (mem_pass == null) {
			if (other.mem_pass != null)
				return false;
		} else if (!mem_pass.equals(other.mem_pass))
			return false;
		return true;
	}

	
	
	
}

package com.assignment.notice.model.dto;

public class MemberDTO {
	
	private String user_id;
	private String user_pwd;
	private String user_nm;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_nm=" + user_nm + "]";
	}
	
	
}

package com.assignment.notice.model.dto;

public class PostDTO {
	private int post_no;
	private String title;
	private String contents;
	private String writer;
	private String writer_nm;
	private String reg_dt;
	private String fin_mdfy_dt;
	private int view_count;
	private String post_pwd;
	
	public int getPostNo() {
		return post_no;
	}
	public void setPostNo(int postNo) {
		this.post_no = postNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriterNm() {
		return writer_nm;
	}
	public void setWriterNm(String writerNm) {
		this.writer_nm = writerNm;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDt() {
		return reg_dt;
	}
	public void setRegDt(String regDt) {
		this.reg_dt = regDt;
	}
	public String getFinMdfyDt() {
		return fin_mdfy_dt;
	}
	public void setFinMdfyDt(String finMdfyDt) {
		this.fin_mdfy_dt = finMdfyDt;
	}
	public int getViewCount() {
		return view_count;
	}
	public void setViewCount(int viewCount) {
		this.view_count = viewCount;
	}
	public String getPostPwd() {
		return post_pwd;
	}
	public void setPostPwd(String postPwd) {
		this.post_pwd = postPwd;
	}
	@Override
	public String toString() {
		return "PostDTO [post_no=" + post_no + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", reg_dt=" + reg_dt + ", fin_mdfy_dt=" + fin_mdfy_dt + ", viewCount=" + view_count + ", postPwd="
				+ post_pwd + "]";
	}
	
	
}

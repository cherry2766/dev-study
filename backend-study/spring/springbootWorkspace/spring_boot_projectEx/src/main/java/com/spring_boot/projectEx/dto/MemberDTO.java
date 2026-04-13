package com.spring_boot.projectEx.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberDTO {
	
	private String memId;
	private String memPwd;
	private String memeName;
	private String memEmail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date memJoinDate;
	private String memHP;
	private String memZipcode;
	private String memAddress1;
	private String memAddress2;
	
	private MemberDTO() {}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemeName() {
		return memeName;
	}

	public void setMemeName(String memeName) {
		this.memeName = memeName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public Date getMemJoinDate() {
		return memJoinDate;
	}

	public void setMemJoinDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}

	public String getMemHP() {
		return memHP;
	}

	public void setMemHP(String memHP) {
		this.memHP = memHP;
	}

	public String getMemZipcode() {
		return memZipcode;
	}

	public void setMemZipcode(String memZipcode) {
		this.memZipcode = memZipcode;
	}

	public String getMemAddress1() {
		return memAddress1;
	}

	public void setMemAddress1(String memAddress1) {
		this.memAddress1 = memAddress1;
	}

	public String getMemAddress2() {
		return memAddress2;
	}

	public void setMemAddress2(String memAddress2) {
		this.memAddress2 = memAddress2;
	}
	
	

}

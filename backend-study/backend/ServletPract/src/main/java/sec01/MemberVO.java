package sec01;

import java.util.Date;

public class MemberVO {
	private String memId;
	private String memPwd;
	private String memName;
	private Date memJoinDate;
	private String memEmail;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String memId, String memPwd, String memName, Date memJoinDate, String memEmail) {
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.memJoinDate = memJoinDate;
		this.memEmail = memEmail;
	}

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

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Date getMemJoinDate() {
		return memJoinDate;
	}

	public void setMemJoinDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	

}

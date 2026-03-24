package bean;

//필드(속성)와 getter/setter만 있는 클래스를 java beans라는 개념으로 사용함
public class StudentBean {
	private String stdNo;
	private String stdName;
	private String stdAddress;
	private String stdPhone;
	private int stdYear;
	private String[] stdInterest;
	
	
	public String getStdNo() {
		return stdNo;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public int getStdYear() {
		return stdYear;
	}
	public void setStdYear(int stdYear) {
		this.stdYear = stdYear;
	}
	public String[] getStdInterest() {
		return stdInterest;
	}
	public void setStdInterest(String[] stdInterest) {
		this.stdInterest = stdInterest;
	}
	
	
}

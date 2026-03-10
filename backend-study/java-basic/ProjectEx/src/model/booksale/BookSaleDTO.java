package model.booksale;

import java.sql.Date;

public class BookSaleDTO {
	private String bsNo;
	private Date bsDate;
	private int bsQty;
	private String clientNo;
	private String bookNo;

	public BookSaleDTO() {

	}

	public BookSaleDTO(String bsNo, Date bsDate, int bsQty, String clientNo, String bookNo) {
		this.bsNo = bsNo;
		this.bsDate = bsDate;
		this.bsQty = bsQty;
		this.clientNo = clientNo;
		this.bookNo = bookNo;
	}
	
	public BookSaleDTO(String bsNo, String clientNo, String bookNo, int bsQty) {
	    this.bsNo = bsNo;
	    this.clientNo = clientNo;
	    this.bookNo = bookNo;
	    this.bsQty = bsQty;
	}

	public String getBsNo() {
		return bsNo;
	}

	public void setBsNo(String bsNo) {
		this.bsNo = bsNo;
	}

	public Date getBsDate() {
		return bsDate;
	}

	public void setBsDate(Date bsDate) {
		this.bsDate = bsDate;
	}

	public int getBsQty() {
		return bsQty;
	}

	public void setBsQty(int bsQty) {
		this.bsQty = bsQty;
	}

	public String getClientNo() {
		return clientNo;
	}

	public void setClientNo(String clientNo) {
		this.clientNo = clientNo;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bsNo);
		builder.append("\t");
		builder.append(bsDate);
		builder.append("\t");
		builder.append(bsQty);
		builder.append("\t");
		builder.append(clientNo);
		builder.append("\t");
		builder.append(bookNo);

		return builder.toString();
	}
}

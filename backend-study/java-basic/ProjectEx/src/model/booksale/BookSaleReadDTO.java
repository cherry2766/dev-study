package model.booksale;

import java.sql.Date;

public class BookSaleReadDTO {
	private String bsNo;
	private String clientName;
	private String bookName;
	private int bookPrice;
	private int bsQty;
	private Date bsDate;

	public BookSaleReadDTO() {

	}

	public BookSaleReadDTO(String bsNo, String clientName, String bookName, int bookPrice, int bsQty, Date bsDate) {
		this.bsNo = bsNo;
		this.clientName = clientName;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bsQty = bsQty;
		this.bsDate = bsDate;
	}

	public String getBsNo() {
		return bsNo;
	}

	public void setBsNo(String bsNo) {
		this.bsNo = bsNo;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBsQty() {
		return bsQty;
	}

	public void setBsQty(int bsQty) {
		this.bsQty = bsQty;
	}

	public Date getBsDate() {
		return bsDate;
	}

	public void setBsDate(Date bsDate) {
		this.bsDate = bsDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bsNo);
		builder.append("\t");
		builder.append(clientName);
		builder.append("\t");
		builder.append(bookName);
		builder.append("\t");
		builder.append(bookPrice);
		builder.append("\t");
		builder.append(bsQty);
		builder.append("\t");
		builder.append(bsDate);

		return builder.toString();
	}
}

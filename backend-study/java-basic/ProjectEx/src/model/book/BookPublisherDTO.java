package model.book;

public class BookPublisherDTO {
	private String bookName;
	private String pubName;

	public BookPublisherDTO(String bookName, String pubName) {
		this.bookName = bookName;
		this.pubName = pubName;
	}

	public String getBookName() {
		return bookName;
	}

	public String getPubName() {
		return pubName;
	}

	@Override
	public String toString() {
		return pubName + "\t" + bookName;
	}
}

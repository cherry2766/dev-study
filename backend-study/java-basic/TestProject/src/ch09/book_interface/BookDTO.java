package ch09.book_interface;

//BookDTO 인스턴스 1개가 1개의 책을 표현

public class BookDTO {
	private String id; // 책 고유 id
	private String title; // 책 이름
	private String author; // 저자
	private String publisher; // 출판사
	private String publishedDate; // 출판일
	private String imageUrl; // 이미지 경로
	private int price; // 가격
	private int stock; // 재고

	public BookDTO(String id, String title, String author, String publisher, 
			String publishedDate, String imageUrl, int price, int stock) { // 생성자 메서드로 초기화 진행
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.imageUrl = imageUrl;
		this.price = price;
		this.stock = stock;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}

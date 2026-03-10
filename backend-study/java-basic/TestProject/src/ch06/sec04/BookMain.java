package ch06.sec04;

public class BookMain {

	public static void main(String[] args) {
		// this() 연습
		BookThisMethod book = new BookThisMethod();
		book = new BookThisMethod("java", "홍길동");
		book = new BookThisMethod("java", 19000);
		
		System.out.println(book.title);
		System.out.println(book.author);
		System.out.println(book.price);
	}

}

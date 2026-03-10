package controller;

import model.book.BookDAO;
import model.book.BookDTO;
import model.book.BookPublisherDTO;
import model.book.IBookDAO;
import util.ResultView;
import view.BookList;
import view.BookSearchByPublisher;

import java.util.ArrayList;
import java.util.Vector;

public class BookController {
	// 싱글톤 : 단 하나의 객체(인스턴스)만 생성
	// static 이지만 private 이므로 클래스 내부에서만 사용 가능함
	private static BookController instance = new BookController();
	IBookDAO dao = new BookDAO();

	// new 연산자 활용 객체 생성 불가능하도록 생성자 오버로딩
	private BookController() {
	}

	// 외부에서 객체 인스턴스 공통 사용 가능하도록 public 메서드 추가
	public static BookController getInstance() {
		return instance;
	}

	// View로부터 dto 전달 받아서 dao를 통해서 db에 저장한 후에 결과에 따라 메시지 출력을 위한 view 호출
	// dao에서 던져지는 예외를 반드시 처리해야 함 (일반적으로 예외는 컨트롤러가 처리)
	public void insert(BookDTO newDto) { // 객체 인스턴스가 있어야 사용가능
		try {
			// view에서 전달된 데이터를 dao로 전달하기 전에 필요하다면 가공 처리
			BookDTO dto = new BookDTO();

			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());

			if (dao.insert(dto)) {
				ResultView.succMsg("도서 정보가 등록되었습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 등록 오류");
		}
	}

	public void getAllBook() {
		try {
			Vector<BookDTO> dataSet = dao.getAllBook();
			if (dataSet.size() != 0) { // 반환된 레코드가 있으면
				BookList.showAllBook(dataSet);
			} else {
				ResultView.succMsg("검색 결과가 없습니다"); // 테이블이 비어있음
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("잠시 후 재요청 바랍니다");
		}

	}

	public void update(BookDTO newDto) {
		try {
			BookDTO dto = new BookDTO();

			dto.setBookNo(newDto.getBookNo());
			dto.setBookName(newDto.getBookName());
			dto.setBookAuthor(newDto.getBookAuthor());
			dto.setBookPrice(newDto.getBookPrice());
			dto.setBookDate(newDto.getBookDate());
			dto.setBookStock(newDto.getBookStock());
			dto.setPubNo(newDto.getPubNo());

			if (dao.update(dto)) {
				ResultView.succMsg("도서 정보를 수정하였습니다. 도서 정보 조회에서 확인하세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 수정 오류");
		}
	}

	public void delete(String bookNo) {
		try {
			BookDTO dto = new BookDTO();

			dto.setBookNo(bookNo);

			if (dao.delete(dto)) {
				ResultView.succMsg("도서 정보를 삭제하였습니다");
			} else {
				ResultView.succMsg("해당하는 도서번호의 도서가 없습니다");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("도서 정보 삭제 오류");
		}
	}

	public void bookSearchByPublisher(String pubName) {
		try {
			ArrayList<BookPublisherDTO> list = dao.getBookByPublisher(pubName);

			System.out.println("도서명 \t 출판사 이름");
			System.out.println("--------------------");

			if (list.size() != 0) {
				for (BookPublisherDTO dto : list) {
					System.out.println(dto);
				}
			} else {
				ResultView.succMsg("검색 결과가 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}
}

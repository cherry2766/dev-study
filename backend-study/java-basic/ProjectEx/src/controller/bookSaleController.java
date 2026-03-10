package controller;

import java.sql.Connection;
import java.util.ArrayList;

import model.book.BookDAO;
import model.booksale.*;

import bookSaleView.BookSaleList;
import bookSaleView.BookSaleSelect;
import util.DBConnect;
import util.ResultView;

public class bookSaleController {
	private static bookSaleController instance = new bookSaleController();
	BookDAO dao = new BookDAO();
	BookSaleDAO saleDao = new BookSaleDAO();

	private bookSaleController() {

	}

	public static bookSaleController getInstance() {
		return instance;
	}

	public void getAllBookSale() {
		try {
			ArrayList<BookSaleReadDTO> list = saleDao.selectAll();
			if (list.size() != 0) {
				BookSaleList.showAllBookSale(list);
			} else {
				ResultView.succMsg("검색 결과가 없습니다"); // 테이블이 비어있음
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("잠시 후 재요청 바랍니다");
		}
	}

	public void getBookSale(String bsNo) {
		try {
			ArrayList<BookSaleReadDTO> list = saleDao.selectByBsNo(bsNo);
			if (list.size() != 0) {
				BookSaleSelect.showBookSaleBybsNo(list);
			} else {
				ResultView.succMsg("검색 결과가 없습니다"); // 테이블이 비어있음
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("잠시 후 재요청 바랍니다");
		}
	}

	public void buy(BookSaleDTO dto) {
		Connection con = null;
		try {
			con = DBConnect.getConnection();
			con.setAutoCommit(false);

			int stock = dao.selectStock(con, dto.getBookNo());
			if (stock < dto.getBsQty())
				throw new Exception("재고 부족 (현재: " + stock + ")");

			boolean saleOk = saleDao.create(con, dto);
			if (!saleOk)
				throw new Exception("주문 등록 실패");

			boolean stockOk = dao.updateStock(con, dto.getBookNo(), -dto.getBsQty());
			if (!stockOk)
				throw new Exception("재고 수정 실패");

			con.commit();
			ResultView.succMsg("구매 완료!");
		} catch (Exception e) {
			try {
				if (con != null)
					con.rollback();
			} catch (Exception error) {
			}
			ResultView.errorMsg("구매 실패: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.setAutoCommit(true);
			} catch (Exception e) {
			}
			DBConnect.close(con);
		}
	}

	public void updateSaleQty(String bsNo, int newQty) {
		Connection con = null;

		try {
			con = DBConnect.getConnection();
			con.setAutoCommit(false);

			// 1) 기존 주문 조회
			BookSaleDTO old = saleDao.select(con, bsNo);
			int oldQty = old.getBsQty();
			String bookNo = old.getBookNo();

			// 2) 차이 계산
			int diff = newQty - oldQty;
			if (diff == 0) {
				throw new Exception("수량이 동일하여 변경할 내용이 없습니다.");
			}

			// 3) 재고 체크(수량 증가인 경우만)
			if (diff > 0) {
				int stock = dao.selectStock(con, bookNo);
				if (stock < diff) {
					throw new Exception("재고 부족 (추가 필요: " + diff + ", 현재 재고: " + stock + ")");
				}
			}

			// 4) 주문 수량 업데이트
			BookSaleDTO newDto = new BookSaleDTO();
			newDto.setBsNo(bsNo);
			newDto.setBsQty(newQty);

			boolean saleOk = saleDao.update(con, newDto);
			if (!saleOk)
				throw new Exception("주문 수정 실패");

			// 5) 재고 반영
			// diff > 0이면 재고 -diff
			// diff < 0이면 재고 +(-diff)
			boolean stockOk = dao.updateStock(con, bookNo, -diff);
			if (!stockOk)
				throw new Exception("재고 반영 실패");

			con.commit();
			ResultView.succMsg("구매내역 수정 완료!");

		} catch (Exception e) {
			try {
				if (con != null)
					con.rollback();
			} catch (Exception error) {
			}
			ResultView.errorMsg("수정 실패: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.setAutoCommit(true);
			} catch (Exception error) {
			}
			DBConnect.close(con);
		}
	}

	public void cancelSale(String bsNo) {
		Connection con = null;

		try {
			con = DBConnect.getConnection();
			con.setAutoCommit(false);

			// 1) 기존 주문 조회
			BookSaleDTO old = saleDao.select(con, bsNo);
			String bookNo = old.getBookNo();
			int qty = old.getBsQty();

			// 2) 주문 삭제
			boolean delOk = saleDao.delete(con, bsNo);
			if (!delOk)
				throw new Exception("주문 삭제 실패");

			// 3) 재고 복구
			boolean stockOk = dao.updateStock(con, bookNo, +qty);
			if (!stockOk)
				throw new Exception("재고 복구 실패");

			con.commit();
			ResultView.succMsg("구매 취소 완료!");

		} catch (Exception e) {
			try {
				if (con != null)
					con.rollback();
			} catch (Exception error) {
			}
			ResultView.errorMsg("취소 실패: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.setAutoCommit(true);
			} catch (Exception error) {
			}
			DBConnect.close(con);
		}
	}

}

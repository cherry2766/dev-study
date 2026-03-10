package ch06.sec03;

public class ReservationMain {

	public static void main(String[] args) {
		//예약
		Reservation rsv = new Reservation("KE1001","홍길동","인천","뉴욕",1600000,"A38");
		rsv.showRsvInfo();
		rsv = null;
		rsv = new Reservation();
		rsv.showRsvInfo();

	}

}

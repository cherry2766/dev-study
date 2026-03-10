package ch06.sec02;

public class SavingsMain {

	public static void main(String[] args) {
		Savings sav = new Savings();

		sav.setName();
		System.out.println("예금주 : " + sav.getName());

		sav.setBalance();
		System.out.println("입금전 잔액 : " + sav.getBalance());

		sav.inputDeposit();

		int interest = sav.getInterest();
		System.out.println("이자 : " + interest);

		int balance = sav.getBalance();
		System.out.println("최종 잔액 : " + balance);
	}

}

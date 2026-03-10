package ch06.sec02;

import java.util.Scanner;

public class Savings {
	private String name;
	private int deposit;
	private int interest;
	private int balance;

	public void setName() {
		name = "홍길동";
	}

	public void setBalance() {
		balance = 10000;
	}

	public String getName() {
		return name;
	}

	public void inputDeposit() {
		Scanner sc = new Scanner(System.in);
		System.out.print("예금액 입력 : ");
		deposit = sc.nextInt();
		balance += deposit;
	}

	public int getInterest() {
		interest = (int) (balance * 0.1);
		balance += interest;
		return interest;
	}

	public int getBalance() {
		return balance;
	}
}

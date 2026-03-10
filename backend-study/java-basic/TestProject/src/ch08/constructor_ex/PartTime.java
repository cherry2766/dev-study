package ch08.constructor_ex;

public class PartTime extends Worker {
	int hours;
	int unitPrice;
	int Pay;

	public PartTime(String joominNo, String name, int hours, int unitPrice) {
		super(joominNo, name);
		this.hours = hours;
		this.unitPrice = unitPrice;
	}

	public int calculatePay() {
		Pay = hours * unitPrice;
		return Pay;
	}

	@Override
	public String toString() {
		return super.toString() + "\n시급 : " + unitPrice + " 원\n근무시간 : " + hours + " 시간\n총지불액 : " + calculatePay() + " 원";
	}

}

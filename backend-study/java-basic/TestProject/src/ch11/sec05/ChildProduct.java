package ch11.sec05;

// sub 클래스에서 super 클래스의 타입 파라미터를 표기해야 함
// sub 클래스에서 결정되지 않은 타입이 있으면 타입파라미터 추가
public class ChildProduct<T,M,C> extends Product<T,M>{
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
	
}

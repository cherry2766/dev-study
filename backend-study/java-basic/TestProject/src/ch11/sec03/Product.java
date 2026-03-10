package ch11.sec03;

public class Product<T,M> {
	private T kind;
	private M model;
	private int price;
	
	public T getKind() {
		return this.kind;
	}
	
	public void setKind(T kind) {
		this.kind = kind;
	}

	public M getModel() {
		return model;
	}

	public void setModel(M model) {
		this.model = model;
	}
	
	
}

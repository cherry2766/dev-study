package ch11.sec03;

public class ProductEx {

	public static void main(String[] args) {
		// 멀티 타입 파라미터 예제
		Product<TV, String> prodTv = new Product<>();
		Product<Car, Integer> prodCar = new Product<>();

		prodTv.setKind(new TV());
		prodTv.setModel("스마트 TV");
		String tvM = prodTv.getModel();
		System.out.println(tvM);

		prodCar.setKind(new Car());
		prodCar.setModel(11112222);
		int model = prodCar.getModel();
		System.out.println(model);
		Car car = prodCar.getKind();

	}

}

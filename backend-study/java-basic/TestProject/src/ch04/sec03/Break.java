package ch04.sec03;

public class Break {

	public static void main(String[] args) {
		// break 문 예제
		// 특정 범위를 벗어나는 역할을 함 - 보통 반복문과 같이 사용함 switch ~ case 문 등에서도 사용
		// 반복취소 문장블럭 종료
		int i = 0;
		while(true) {
			//무한반복일 경우에는 반복문 내부 코드에서 종료에 해당하는 코드를 구성해야 함
			System.out.println(i);
			i+=3; //3씩 증가
			if(i>20) //20보다 크면
				break; //break문이 포함된 가장 가까운 반복 블럭을 벗어남
		}
		System.out.println("break에 의해 반복 종료!!!");
	}

}

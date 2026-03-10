package ch04.sec03;

public class Continue {

	public static void main(String[] args) {
		// continue문 : 특정 조건에 다다르면 해당 실행 블럭의 남은 코드를 실행하지 않고 다음 반복을 진행함
		for(int i=1; i<=10; i++) {
			if(i%2 !=0)
				continue; // 이후 문장 수행을 중단하고 다음 반복을 진행
			System.out.println(i);
			//continue; 조건 없이 continue 사용하면 아래문장에서 오류남
			//System.out.println(i);
		}

	}

}

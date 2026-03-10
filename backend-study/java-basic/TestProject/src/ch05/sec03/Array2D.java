package ch05.sec03;

public class Array2D {

	public static void main(String[] args) {
		// 2차원 배열 형식
		int[][] a = new int[3][4]; // 2차원 배열 참조 시작(기본값 0으로 초기화)
		a = null; // 2차원 배열 참조 끝(삭제)

		int[][] a1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		char[][] b = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };

		int[][] score = { 
				{ 100, 100, 100 }, 
				{ 20, 20, 20 }, 
				{ 30, 30, 30 }, 
				{ 40, 40, 40 }, 
				{ 50, 50, 50 } 
				};
		// 배열 idx 0부터 시작 2차원 배열 접근 : 배열[행인덱스][열인덱스]
		System.out.println(score[0][0]);
		// 2차원 배열 length 속성 값 : 행의 수
		System.out.println(score.length);
		// 2차원 배열[행인덱스].length : 해당 행의 원소수
		System.out.println(score[0].length);
		// 2차원 배열[행인덱스] : 행의 시작주소
		System.out.println(score[0]); // [I@2ff4acd0
		System.out.println(score); // [[I@54bedef2 : [[ 2차원 배열
		
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]); //각 행의 시작 주소
		}
		
		//배열의 모든 원소 출력
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.printf("score[%d][%d]=%d\n",i,j,score[i][j]);
			}
			System.out.println();
		}

	}

}

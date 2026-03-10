package ch05.sec03;

public class IrregularArray {

	public static void main(String[] args) {
		// 가변배열(비 정방형 배열)
		// 각 행마다 열의 개수가 다른 배열
		int[][] a = new int[4][]; // 행의 수만 결정된 2차원 배열
		// 열의 수 결정(원소수 결정) : 행마다 원소수를 다르게 결정
		a[0] = new int[1];
		a[1] = new int[2];
		a[2] = new int[3];
		a[3] = new int[4];

		char b[][] = { { 'a' }, { 'b', 'c' }, { 'd', 'e', 'f' } }; // new char[3][]

		// 배열의 모든 원소 출력
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.printf("b[%d][%d]=%c\n", i, j, b[i][j]);
			}
			System.out.println();
		}

	}

}

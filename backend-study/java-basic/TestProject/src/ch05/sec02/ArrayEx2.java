package ch05.sec02;

import java.util.Arrays;
import java.util.Random;

public class ArrayEx2 {

	public static void main(String[] args) {
		Random random = new Random();
		int[] lotto = new int[6];
		int randomNum;
		int idx = 0;

		while (idx < lotto.length) {
			randomNum = random.nextInt(45) + 1;
			if (!checkNum(lotto, randomNum)) {
				lotto[idx] = randomNum;
				idx++;
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}

	public static boolean checkNum(int[] lotto, int randomNum) {
		for (int num : lotto) {
			if (num == randomNum)
				return true; // 중복 발생
		}
		return false; // 중복 없음
	}
}

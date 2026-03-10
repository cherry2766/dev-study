package ch05.sec01;

import java.util.Scanner;

public class ArrayInputEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[5];
		int maxValue = 0;
		
		System.out.println("숫자 입력");
			for(int i=0; i<nums.length; i++) {
				System.out.printf("nums[%d] : ", i);
				nums[i] = sc.nextInt();
			}
			
			maxValue = nums[0];
			for(int i=0; i<nums.length; i++) {
				if(maxValue < nums[i])
					maxValue = nums[i];
			}	
			
			System.out.print("\n입력된 값 : ");
			for(int i=0; i<nums.length; i++) {
			    System.out.printf("%d ", nums[i]);
			}
			System.out.printf("\n최대값 : %d", maxValue);
			
		sc.close();
	}

}

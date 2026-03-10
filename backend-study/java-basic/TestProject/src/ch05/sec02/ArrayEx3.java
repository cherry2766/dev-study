package ch05.sec02;
import java.util.Arrays;
import java.util.Random;

public class ArrayEx3 {
  public static void main(String[] args) {
      Random random = new Random();
      int[] nums = new int[10];

      for(int i=0; i<nums.length;i++) {
          nums[i] = random.nextInt(10);
      }
      System.out.println(Arrays.toString(nums));

      int[] count = new int[10];

      for(int num : nums) {
          count[num]++;
      }
      for(int i=0; i<count.length; i++) {
          System.out.println(i + "의 개수 : " + count[i]);
      }
  }
}
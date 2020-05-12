package stu.edu.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Admin
 * 给定一个整数数组 nums 和一个目标值 target
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class TwoSum {

  /**
   * 利用HashMap
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      int num = target - nums[i];
      if(!map.isEmpty() && map.containsKey(num)) {
        return new int[] {map.get(num),i};
      }
      map.put(nums[i],i);
    }
    throw new RuntimeException();
  }

  /**
   * 碰撞指针法
   * 本质上来讲其实就是二分查找法
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums, int target) {
    int i = 0, j = nums.length-1;
    for (;i<j;) {
      if(nums[i] + nums[j] == target) {
        return new int[]{i,j};
      }else if(nums[i] + nums[j] > target) {
        j--;
      }else {
        i++;
      }
    }
    throw new RuntimeException("Not Found.");
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};
    System.out.println(Arrays.toString(twoSum2(nums,5)));
  }
}

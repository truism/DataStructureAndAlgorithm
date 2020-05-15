package stu.edu.InterviewQuestion;

import java.util.Arrays;

/**
 * 单调栈
 *
 * 原问题：准备一个栈，记为 stack＜Integer＞，栈中放的元素是数组的位置，
 * 开始时 stack 为空。如果找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置，
 * 那么需要让stack从栈顶到栈底的位置所代表的值是严格递减的；
 * 如果找到每一个i位置左边和右边离i位置最近且值比arr[i]大的位置，那么需要让 stack从栈顶到栈底的位置所代表的值是严格递增的。
 *
 * 给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。
 * 若没有则存入-1，返回所有位置相应的信息
 */
public class MonotonicStack {

  public static void main(String[] args) {
    int[] arr = new int[] {3,4,1,5,6,2,7};
    int[][] res = rightWay(arr);
    for (int i = 0; i < res.length; i++) {
      System.out.println(Arrays.toString(res[i]));
    }
  }

  /**
   * 暴力解法
   * @param arr
   * @return
   */
  public static int[][] rightWay(int[] arr) {
    int[][] res = new int[arr.length][2];
    for (int i = 0; i < arr.length; i++) {
      int[] temp = new int[2];
      // 从左往右查找
      for (int j=i+1; j<arr.length; j++) {
        if(arr[j] < arr[i]) {
          temp[1] = j;
          break;
        }
      }
      // 从右往左查找
      for (int j = i-1; j >=0 ; j--) {
        if(arr[j] < arr[i]) {
          temp[0] = j;
          break;
        }
      }
      if(i == 0) {
        temp[0] = -1;
        if(temp[1] == 0) {
          temp[1] = -1;
        }
      }
      if(i == arr.length - 1) {
        temp[1] = -1;
        if(temp[0] == 0) {
          temp[0] = -1;
        }
      }
      // 两边都未找到
      if(temp[0] == 0 && temp[1] == 0 ) {
        temp[0] = -1;
        temp[1] = -1;
      }
      res[i] = temp;
    }
    return res;
  }

}

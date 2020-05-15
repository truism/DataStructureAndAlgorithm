package stu.edu.InterviewQuestion;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 *
 */
public class SlidingWindow {

  public static void main(String[] args) {
    int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
    int[] res = slidingWindow(arr,3);
    System.out.println(Arrays.toString(res));
  }

  /**
   * 利用双端队列的O(n)解法
   * @param arr 目标数组
   * @param len 滑动窗口长度
   * @return 滑动窗口最大值数组
   */
  public static int[] slidingWindow(int[] arr, int len) {
    if(arr == null || len < 1 || arr.length <= 1) {
      return null;
    }
    int[] res = new int[arr.length - len + 1];
    LinkedList<Integer> queue = new LinkedList();
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      // 保存一个窗口中的最大值的索引
      while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
        queue.pollLast();
      }
      queue.add(i);
      if(queue.peekFirst() == i - len) {
        queue.pollFirst();
      }
      if(i >= len - 1) {
        res[index++] = arr[i];
      }
    }
    return res;
  }

  /**
   * 滑动窗口最大值的暴力解法O(N*W)
   * @param arr
   * @param len
   * @return
   */
  public static int[] forceSolution(int[] arr, int len) {
    // 滑动窗口值的数目就是原数组长度 - 滑动窗口长度 + 1
    int[] res = new int[arr.length - len + 1];
    // win[left,right] 代表滑动窗口
    int left = 0;
    int right = -1;
    for (int i = 0; i <= arr.length-len; i++) {
      left = i;
      right = left;
      int max = arr[right];
      while (right < (left + len - 1)) {
        right++;
        max = arr[right] > max ? arr[right] : max;
      }
      res[i] = max;
    }
    return res;
  }
}

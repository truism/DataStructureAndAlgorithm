package stu.edu.InterviewQuestion;


import java.util.Arrays;
import java.util.Stack;

/**
 * 题目描述：
 * 传入一个数组，找到离每一个数组元素最近的比它的元素并放入新数组相同的位置，最后返回新数组
 */
public class NextGreaterElement {

  public static void main(String[] args) {
    int[] nums = {2,1,2,4,3,6,2};
    System.out.println(Arrays.toString(nextGreaterElement(nums)));
  }

  public static int[] nextGreaterElement(int[] nums) {

    Stack<Integer> stack = new Stack<>();
    int[] res = new int[nums.length];
    for (int i = nums.length - 1; i>=0; i--) {
      while (!stack.empty() && stack.peek() <= nums[i]) {
        stack.pop();
      }
      res[i] = stack.empty() ? -1 : stack.peek();
      stack.push(nums[i]);
    }
    return res;
  }

}

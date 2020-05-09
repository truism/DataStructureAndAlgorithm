package stu.edu.InterviewQuestion;

import java.util.Stack;

/**
 * 判断一个数组是否是另外一个数组出栈的顺序
 *
 */
public class TwoArrayIfFromStack {

  public static void main(String[] args) {
    int[] push = new int[] {1,2,3,4,5};
    int[] pop = new int[] {4,3,5,1,2};
    System.out.println(isRelative(push,pop));
  }

  public static boolean isRelative(int[] push, int[] pop) {
    if(push == null || pop == null) {
      return false;
    }
    Stack<Integer> stack = new Stack<>();
    int p = 0;
    for (int i = 0; i < push.length; i++) {
      stack.push(push[i]);
      while (!stack.isEmpty() && stack.peek() == pop[p]) {
        p++;
        stack.pop();
      }
    }
    if(stack.isEmpty()) {
      return true;
    }
    return false;
  }

}

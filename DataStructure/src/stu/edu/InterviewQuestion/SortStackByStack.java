package stu.edu.InterviewQuestion;

import java.util.Stack;

/**
 * 利用栈对栈中元素进行排序
 */
public class SortStackByStack {

  public static void main(String[] args) {
    int[] arr = new int[] {1,3,2,5,4,8,7,6,9,2,3,1};
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      stack.push(arr[i]);
    }
    sortStack(stack);
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + "  ");
    }
  }


  public static void sortStack(Stack<Integer> stack) {
    Stack<Integer> help = new Stack<>();
    while (!stack.isEmpty()) {
      if(help.isEmpty() || help.peek() <= stack.peek()) {
        help.push(stack.pop());
      }else if(help.peek() > stack.peek()) {
        int res = stack.pop();
        while (help.peek() > res) {
          stack.push(help.pop());
        }
        help.push(res);
      }
    }
    while (!help.isEmpty()) {
      stack.push(help.pop());
    }
  }


}

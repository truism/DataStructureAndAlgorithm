package stu.edu.InterviewQuestion;

import java.util.Stack;

/**
 * 利用递归函数和一个栈来实现栈的逆序
 */
public class ReverseStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    reverseStack(stack);
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  /**
   * 生成一个逆序栈
   * @param stack
   */
  public static void reverseStack(Stack<Integer> stack) {
    if(stack.isEmpty()) {
      return;
    }
    int i = getStackLastElement(stack);
    reverseStack(stack);
    stack.push(i);
  }

  /**
   * 如何获取一个栈的栈底元素，利用递归实现
   * @param stack
   */
  private static Integer getStackLastElement(Stack<Integer> stack) {
    int result = stack.pop();
    if(stack.isEmpty()) {
      return result;
    }else {
      int last = getStackLastElement(stack);
      stack.push(result);
      return last;
    }
  }
}

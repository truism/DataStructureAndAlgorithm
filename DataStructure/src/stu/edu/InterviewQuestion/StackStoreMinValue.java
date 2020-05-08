package stu.edu.InterviewQuestion;

import java.util.Stack;

/**
 *
 */
public class StackStoreMinValue {

  public static void main(String[] args){
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(-3);
    stack.push(-2);
    stack.push(1);
    stack.push(0);
    System.out.println(stack.min());
  }

  static class MyStack {
    int data;
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int val) {
      s1.push(val);
      if(s2.isEmpty() || s2.peek() > val) {
        s2.push(val);
      }
    }

    int pop() {
      int x = s1.pop();
      if(x == s2.peek()) {
        s2.pop();
      }
      return x;
    }

    int min() {
      return s2.peek();
    }
  }

}

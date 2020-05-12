package stu.edu.InterviewQuestion;

import java.util.Stack;

/**
 * 支持获取最小值的栈
 * @param <T>
 */
public class MinStack<T extends Comparable<T> > {

  public static void main(String[] args) {
    MinStack<Integer> minStack = new MinStack<>();
    minStack.push(2);
    minStack.push(3);
    System.out.println(minStack.getMin());
    minStack.push(1);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
  }

  private Stack<T> stackData;
  private Stack<T> stackMin;

  public MinStack() {
    this.stackData = new Stack<>();
    this.stackMin = new Stack<>();
  }

  public void push(T data) {
    stackData.push(data);
    if(stackMin.isEmpty() || stackMin.peek().compareTo(data) > 0) {
      stackMin.push(data);
    }
  }

  public T pop() {
    T value = stackData.pop();
    if(value.equals(stackMin.peek())) {
      stackMin.pop();
    }
    return value;
  }

  public T getMin() {
    return stackMin.peek();
  }
}

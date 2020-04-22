package stu.edu.InterviewQuestion;


import java.util.Stack;

/**
 * @author Admin
 * 两个栈实现队列
 */
public class TwoStackImplementList {

    public static void main(String[] args) {
        MyList list = new MyList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
    }


    static class MyList {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyList() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public int pop() {
            if(stack1.isEmpty() &&stack2.isEmpty()) {
                throw new IllegalStateException("MyList is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int result = stack2.pop();
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }

        /**
         *
         * @param num
         */
        public void push(int num) {
            stack1.push(num);
        }
    }

}

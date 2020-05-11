package stu.edu.LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 将一个数组中的0全部移到数组末尾，其他元素的相对位置不变
 * @author Admin
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,3};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZero(int[] num) {
        if(num == null || num.length <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0) {
                stack.push(num[i]);
            }
        }
        int size = stack.size();
        for(int i=size; i>0; i--) {
            num[i-1] = stack.pop();
        }
        for (int i = size; i < num.length; i++) {
            num[i] = 0;
        }
    }
}

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
        moveZeroByChange(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 借用栈或队列
      * @param num
     */
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

    /**
     * 双指针法
     * @param num
     */
    public static void moveZeroToLast(int[] num) {
        int k = 0;
        for(int i=0; i<num.length; i++) {
            if(num[i] != 0) {
                num[k++] = num[i];
            }
        }
        for(int i=k; i<num.length; i++) {
            num[i] = 0;
        }
    }

    /**
     * 将非0元素与首个0元素交换
     * @param num
     */
    public static void moveZeroByChange(int[] num) {
        // [0,k) 代表非0元素
        int k = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0) {
                if(k != i) {
                    swap(num, k++, i);
                }else {
                    k++;
                }
            }
        }
    }

    private static void swap(int[] num, int p, int q) {
        int temp = num[p];
        num[p] = num[q];
        num[q] = temp;
    }
}

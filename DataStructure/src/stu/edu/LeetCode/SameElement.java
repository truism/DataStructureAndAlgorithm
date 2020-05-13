package stu.edu.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  取出两个集合中的相同元素
 * @author Admin
 */
public class SameElement {


    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,4};
        int[] arr2 = new int[] {2,2,3};
        Set<Integer> res = sameElement(arr1, arr2);
        for(Integer i : res) {
            System.out.println(i);
        }
    }

    public static Set<Integer> sameElement(int[] num1, int[] num2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < num1.length; i++) {
            set.add(num1[i]);
        }
        for (int i = 0; i < num2.length; i++) {
            if(set.contains(num2[i])) {
                res.add(num2[i]);
            }
        }
        return res;
    }

}

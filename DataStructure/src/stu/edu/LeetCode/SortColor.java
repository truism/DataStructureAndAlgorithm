package stu.edu.LeetCode;

import java.util.Arrays;

/**
 * 对数组元素只有 0 1 2三种元素的数组进行排序
 * @author Admin
 */
public class SortColor {
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,1,2,0,1,2,2,1,1,0};
        sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  时间复杂度为O(n)
     *  空间复杂度为O(n)
     * @param arr
     */
    public static void sort(int[] arr) {
        // count[0] count[1] count[2] 分别对 0 1 2 的个数进行计数
       int[] count = new int[3];
       for(int i=0; i<arr.length; i++) {
           if(arr[i] == 0) {
               count[0] ++;
           }else if(arr[i] == 1) {
               count[1] ++;
           }else {
               count[2] ++;
           }
       }
       fill(arr,count,new int[]{0,1,2});
    }

    private static void fill(int[] arr, int[] count, int[] source) {
        // 代表填充的次数
        int cnt = 0;
        for(int i=0,j=0; i<arr.length; i++) {
            arr[i] = source[j];
            cnt++;
            if(cnt == count[j]) {
                j++;
                cnt = 0;
            }
        }
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 双指针法
     * @param arr
     */
    public static void sortColor(int[] arr) {
        // [0,zero] 存储0
        int zero = -1;
        //[two,arr.length-1] 存储2
        int two = arr.length;
        for (int i = 0; i < two; ) {
            if(arr[i] == 1) {
                i++;
            }else if(arr[i] == 2) {
                two--;
                swap(arr,i,two);
            }else {
                zero++;
                swap(arr, zero, i);
                i++;
            }
        }
    }

    private static void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}

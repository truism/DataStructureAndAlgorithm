package stu.edu.LeetCode;

/**
 * 输入一个数组和目标值，求这个数组的子数组满足子数组之和大于等于目标值且子数组长度最小，返回这个子数组的长度
 * @author Admin
 */
public class MinimumSizeSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(minSize(arr,10));
    }


    public static int minSize(int[] arr, int target) {
        // [l,r] 代表窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = arr.length + 1;
        while (l < arr.length) {
            if(l + 1 < arr.length && sum < target) {
                sum += arr[++r];
            }else {
                sum -= arr[l++];
            }
            if(sum >= target) {
                // res 保存了上一次符合要求的滑动窗口的大小
                res = Math.min(res, r-l+1);
            }
        }
        if(res == arr.length + 1) {
            return 0;
        }
        return res;
    }


}

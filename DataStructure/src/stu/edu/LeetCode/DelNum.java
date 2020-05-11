package stu.edu.LeetCode;

/** 删除数组中指定的元素，返回数组剩余元素的个数
 * @author Admin
 */
public class DelNum {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,4,4,4};
        System.out.println(delTarget(arr,1));
        System.out.println(delTarget(arr,2));
    }

    /**
     * 时间复杂度O(n)
     * @param arr
     * @param target
     * @return
     */
    public static int delTarget(int[] arr, int target) {
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                count--;
            }
        }
        return count;
    }


}

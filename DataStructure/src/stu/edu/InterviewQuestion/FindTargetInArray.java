package stu.edu.InterviewQuestion;

/**
 * @author Admin
 * 题目描述：在二维数组中查找目标值，数组从左往右逐渐增大，从上往下逐渐增大
 */
public class FindTargetInArray {

    /**
     * 双指针法
     * 时间复杂度 O(mn)，空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    public static boolean findTarget(int[][] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int row = 0;
        int column = nums[0].length - 1;
        while (row < nums.length && column >= 0) {
            if(nums[row][column] == target) {
                return true;
            }
            if(nums[row][column] < target) {
                row ++;
            }else {
                column --;
            }
        }
        return false;
    }

    /**
     * 二分法
     * 时间复杂度 O(logmN)，空间复杂度 O(1)
     * @param nums
     * @param target
     * @return
     */
    public static boolean findTarget2(int[][] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length * nums[0].length - 1;
        int col = nums[0].length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = nums[mid/col][mid%col];
            if(val < target) {
                left = mid + 1;
            }else if(val > target) {
                right = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int target = 10;
        System.out.println(findTarget2(nums,target));
    }

}

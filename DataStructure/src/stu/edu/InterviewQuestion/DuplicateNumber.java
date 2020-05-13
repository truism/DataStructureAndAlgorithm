package stu.edu.InterviewQuestion;

/**
 * 长度为n的数字内数字为 0 ~ n-1
 * 找到数组中第一个重复的元素
 * @author Admin
 */
public class DuplicateNumber {

    public static void main(String[] args) {
        int[] arr = new int[] {6,2,4,3,5,2,1,3};
        System.out.println(duplicateNUmber(arr));
    }

    public static int duplicateNUmber(int[] arr) {
        if(arr == null || arr.length <= 1) {
            throw new RuntimeException("No duplicate number.");
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if(arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                // 将元素arr[i]放到第i位
                swap(arr, i, arr[i]);
            }
        }
        throw new RuntimeException("No duplicate number.");
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

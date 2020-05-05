package stu.edu.InterviewQuestion;

/**
 * 整数m改变为整数n，其对应的二进制数需要改变多少位
 * @author Admin
 */
public class NumChangeCount {

    public static void main(String[] args) {
        System.out.println(changeCount(2,3));
        System.out.println(changeCount(4,2));
    }

    public static int changeCount(int m, int n) {
        // 求m与n的异或
        int result = m ^ n;
        return countOne(result);
    }

    public static int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

}
